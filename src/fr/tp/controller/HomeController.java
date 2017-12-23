package fr.tp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.tp.dao.IDAO;
import fr.tp.dao.IQuestionDAO;
import fr.tp.dao.IResponseDAO;
import fr.tp.models.Formation;
import fr.tp.models.Question;
import fr.tp.models.Quiz;
import fr.tp.models.Response;
import fr.tp.models.Student;
import fr.tp.models.StudentTest;
import fr.tp.models.Subject;
import fr.tp.models.Test;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	IDAO<Test> daoTest;

	@Autowired
	IDAO<Formation> daoFormation;

	@Autowired
	IDAO<Quiz> daoQuiz;

	@Autowired
	IDAO<Subject> daoSubject;

	@Autowired
	IDAO<Student> daoStudent;

	@Autowired
	IDAO<StudentTest> daoStudentTest;

	@Autowired
	IQuestionDAO daoQuestion;

	@Autowired
	IResponseDAO daoResponse;

	// private RestTemplate restTemplate = new RestTemplate();

	@Autowired
	ServletContext context;

	public static String getURLWithContextPath(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
	}

	@InitBinder
	protected void initBinderTests(WebDataBinder binder) {
		binder.registerCustomEditor(List.class, "tests", new CustomCollectionEditor(List.class) {
			@Override
			protected Object convertElement(Object element) {
				Integer id = null;

				if (element instanceof String && !((String) element).equals("")) {
					try {
						id = Integer.parseInt((String) element);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
				} else if (element instanceof Integer) {
					id = (Integer) element;
				}

				return id != null ? daoTest.get(Test.class, id) : null;
			}
		});
	}

	@InitBinder
	protected void initBinderResponses(WebDataBinder binder) {
		binder.registerCustomEditor(List.class, "responses", new CustomCollectionEditor(List.class) {
			@Override
			protected Object convertElement(Object element) {
				Integer id = null;

				if (element instanceof String && !((String) element).equals("")) {
					try {
						id = Integer.parseInt((String) element);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
				} else if (element instanceof Integer) {
					id = (Integer) element;
				}

				return id != null ? daoResponse.get(Response.class, id) : null;
			}
		});
	}

	@RequestMapping("/tests")
	public String tests(Model model, HttpSession session, HttpServletRequest request) {
		model.addAttribute("test", new Test());

		List<Test> tests = daoTest.getAll(Test.class);
		context.setAttribute("values", tests);

		List<Formation> formations = daoFormation.getAll(Formation.class);
		context.setAttribute("formations", formations);

		return "tests";
	}

	@RequestMapping("/quizzes")
	public String quizzes(Model model, HttpSession session, HttpServletRequest request) {
		model.addAttribute("quiz", new Quiz());

		List<Quiz> quizzes = daoQuiz.getAll(Quiz.class);
		context.setAttribute("values", quizzes);
		List<Subject> subjects = daoSubject.getAll(Subject.class);
		context.setAttribute("subjects", subjects);
		List<Test> tests = daoTest.getAll(Test.class);
		context.setAttribute("tests", tests);

		return "quizzes";
	}

	@RequestMapping("/formations")
	public String formations(Model model, HttpSession session, HttpServletRequest request) {
		model.addAttribute("formation", new Formation());

		List<Formation> formations = daoFormation.getAll(Formation.class);
		context.setAttribute("values", formations);

		return "formations";
	}

	@RequestMapping("/subjects")
	public String subjects(Model model, HttpSession session, HttpServletRequest request) {
		model.addAttribute("subject", new Subject());

		List<Subject> subjects = daoSubject.getAll(Subject.class);
		context.setAttribute("values", subjects);

		return "subjects";
	}

	@RequestMapping("/students")
	public String students(Model model, HttpSession session, HttpServletRequest request) {
		model.addAttribute("form", new StudentTestForm());

		List<Student> students = daoStudent.getAll(Student.class);
		context.setAttribute("values", students);
		List<Test> tests = daoTest.getAll(Test.class);
		context.setAttribute("tests", tests);

		return "students";
	}

	@RequestMapping("/questions/{id}")
	public String questions(@PathVariable("id") int id, Model model, HttpSession session, HttpServletRequest request) {
		Question q = new Question();
		q.setQuiz(daoQuiz.get(Quiz.class, id));

		model.addAttribute("question", q);
		context.setAttribute("values", daoQuestion.getByQuizId(id));

		return "questions";
	}

	@RequestMapping("/responses/{id}")
	public String responses(@PathVariable("id") int id, Model model, HttpSession session, HttpServletRequest request) {
		Response r = new Response();
		r.setQuestion(daoQuestion.get(Question.class, id));

		model.addAttribute("response", r);
		context.setAttribute("values", daoResponse.getByQuestionId(id));

		return "responses";
	}

	@RequestMapping("/questions/update/{id}")
	public String questionsSaved(@PathVariable("id") int id, Model model, HttpSession session,
			HttpServletRequest request) {
		Question q = daoQuestion.get(Question.class, id);

		model.addAttribute("question", q);

		return "questions.saved";
	}
	
	@RequestMapping("/responses/update/{id}")
	public String responsesSaved(@PathVariable("id") int id, Model model, HttpSession session,
			HttpServletRequest request) {
		Response r = daoResponse.get(Response.class, id);

		model.addAttribute("response", r);

		return "responses.saved";
	}


	@RequestMapping(value = "/save/{type}/{types}", method = RequestMethod.POST)
	public String save(@PathVariable("type") String type, @PathVariable("types") String types,
			@ModelAttribute("test") Test test, @ModelAttribute("quiz") Quiz quiz,
			@ModelAttribute("formation") Formation formation, @ModelAttribute("subject") Subject subject,
			@ModelAttribute("form") StudentTestForm studentTestForm, @ModelAttribute("question") Question question,
			@ModelAttribute("response") Response response, Model model, HttpServletRequest request,
			HttpSession session) {

		switch (type) {
		case "test":
			test.setFormation(daoFormation.get(Formation.class, test.getFormation().getId()));
			daoTest.save(test);
			break;
		case "quiz":
			quiz.setSubject(daoSubject.get(Subject.class, quiz.getSubject().getId()));
			daoQuiz.save(quiz);
			break;
		case "formation":
			daoFormation.save(formation);
			break;
		case "subject":
			daoSubject.save(subject);
			break;
		case "student":
			Student student = daoStudent.save(studentTestForm.getStudent());
			
			if (request.getParameterValues("testsIds") != null) {
				studentTestForm
						.setTestsIds(new ArrayList<String>(Arrays.asList(request.getParameterValues("testsIds"))));

				for (Iterator<String> i = studentTestForm.getTestsIds().iterator(); i.hasNext();) {
					String testId = i.next();
					StudentTest st = new StudentTest();
					st.setStudent(student);

					Test t = daoTest.get(Test.class, Integer.parseInt(testId));
					st.setTest(t);

					String studentId = Integer.toString(student.getId());

					String identifier = "";

					for (int j = 0; j < 3 - testId.length(); j++) {
						identifier += "0";
					}

					identifier += testId;

					for (int j = 0; j < 3 - studentId.length(); j++) {
						identifier += "0";
					}

					identifier += studentId;

					st.setStudentIdentifier(identifier);

					student.getStudentTests().add(st);
				}
			}

			daoStudent.save(student);
			break;
		case "question":
			question.setQuiz(daoQuiz.get(Quiz.class, question.getQuiz().getId()));
			Question q = daoQuestion.save(question);
			types += "/" + q.getQuiz().getId();
			break;
		case "response":
			response.setQuestion(daoQuestion.get(Question.class, response.getQuestion().getId()));

			if (response.isCorrect()) {
				for (Iterator<Response> i = response.getQuestion().getResponses().iterator(); i.hasNext();) {
					Response r = i.next();
					if (r.isCorrect()) {
						r.setCorrect(false);
						daoResponse.save(r);
					}
				}
			}

			Response r = daoResponse.save(response);
			types += "/" + r.getQuestion().getId();
			break;
		}
		return "redirect:/home/" + types;
	}

	@RequestMapping(value = "/delete/{type}/{types}/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable("type") String type, @PathVariable("types") String types,
			@PathVariable("id") int id, Model model, HttpServletRequest request) {

		switch (type) {
		case "test":
			daoTest.delete(daoTest.get(Test.class, id));
			break;
		case "quiz":
			daoQuiz.delete(daoQuiz.get(Quiz.class, id));
			break;
		case "formation":
			daoFormation.delete(daoFormation.get(Formation.class, id));
			break;
		case "subject":
			daoSubject.delete(daoSubject.get(Subject.class, id));
			break;
		case "student":
			daoStudent.delete(daoStudent.get(Student.class, id));
			break;
		case "question":
			Question q = daoQuestion.get(Question.class, id);
			types += "/" + q.getQuiz().getId();
			daoQuestion.delete(q);
			break;
		case "response":
			types += "/" + daoResponse.get(Response.class, id).getQuestion().getId();
			daoResponse.delete(daoResponse.get(Response.class, id));
			break;
		}
		return "redirect:/home/" + types;
	}
}
