package jp.ken.review.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import jp.ken.review.entity.Trainee;
import jp.ken.review.model.FormModel;
import jp.ken.review.model.HistoryModel;
import jp.ken.review.model.LoginModel;

@Component
public class MembershipDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private PlatformTransactionManager transactionManager;

	private RowMapper<Trainee> traineeMapper = new BeanPropertyRowMapper<Trainee>(Trainee.class);
	private RowMapper<FormModel> formMapper = new BeanPropertyRowMapper<FormModel>(FormModel.class);

	public List<Trainee> getList() {
		String sql = "SELECT * FROM t_trainee";
		List<Trainee> traineeList = jdbcTemplate.query(sql, traineeMapper);
		return traineeList;
	}

	public int insert(Trainee trainee) {
		String sql = "INSERT INTO t_trainee(traineeId, traineeName, password, companyName) VALUES(?,?,?,?);";
		Object[] parameters = { trainee.getTraineeId(), trainee.getTraineeName(), trainee.getPasswaord(),
				trainee.getCompanyName() };
		TransactionStatus transactionStatus = null;
		DefaultTransactionDefinition transactionDefenision = new DefaultTransactionDefinition();
		int numberOfRow = 0;
		transactionStatus = transactionManager.getTransaction(transactionDefenision);
		numberOfRow = jdbcTemplate.update(sql, parameters);
		transactionManager.commit(transactionStatus);

		return numberOfRow;

	}

	public int insert(FormModel formModel) {
		String sql = "INSERT INTO t_form VALUES(?,?,?,?,?,?,?,?,?,?);";
		Object[] parameters = { formModel.getDate(), formModel.getName(), formModel.getLessonType(),
				formModel.getPrivacy(), formModel.getContents(), formModel.getComprehensionLevel(),
				formModel.getUnclearPoints(), formModel.getEvaluation(), formModel.getCommentOfInstructor(),
				formModel.getCommentOfToday() };
		TransactionStatus transactionStatus = null;
		DefaultTransactionDefinition transactionDefenision = new DefaultTransactionDefinition();
		int numberOfRow = 0;
		transactionStatus = transactionManager.getTransaction(transactionDefenision);
		numberOfRow = jdbcTemplate.update(sql, parameters);
		transactionManager.commit(transactionStatus);

		return numberOfRow;

	}

	public List<FormModel> getFormHistroyByName(LoginModel loginModel) {
		String sql = "SELECT * FROM t_form WHERE name = ?;";
		Object[] parameters = { loginModel.getName() };
		List<FormModel> formList = jdbcTemplate.query(sql, parameters, formMapper);
		return formList;
	}

	public List<FormModel> getFormHistroyBy1(HistoryModel historyModel, LoginModel loginModel) {

		String sql = "SELECT * FROM t_form WHERE date=? AND contents=? AND comprehensionLevel=?;";
		Object[] parameters = { historyModel.getDate(), historyModel.getContents(),historyModel.getComprehensionLevel() };

		List<FormModel> formList = jdbcTemplate.query(sql, parameters, formMapper);
		return formList;
	}

	public List<FormModel> getFormHistroyBy2(HistoryModel historyModel) {

		String sql = "SELECT * FROM t_form WHERE date=? AND contents=?;";
		Object[] parameters = { historyModel.getDate(), historyModel.getContents() };

		List<FormModel> formList = jdbcTemplate.query(sql, parameters, formMapper);
		return formList;
	}

	public List<FormModel> getFormHistroyBy3(HistoryModel historyModel) {

		String sql = "SELECT * FROM t_form WHERE date=? AND comprehensionLevel=?;";
		Object[] parameters = { historyModel.getDate(), historyModel.getComprehensionLevel() };

		List<FormModel> formList = jdbcTemplate.query(sql, parameters, formMapper);
		return formList;
	}

	public List<FormModel> getFormHistroyBy4(HistoryModel historyModel) {

		String sql = "SELECT * FROM t_form WHERE date=?;";
		Object[] parameters = { historyModel.getDate()};

		List<FormModel> formList = jdbcTemplate.query(sql, parameters, formMapper);
		return formList;
	}


	public Trainee loginCheck(LoginModel loginModel){
		try {
			String sql = "SELECT * FROM t_trainee WHERE (traineeName=? OR companyName=?) AND password=?";
			Object[] parameters = {loginModel.getName(), loginModel.getName(), loginModel.getPassword()};
			Trainee trainee = jdbcTemplate.queryForObject(sql, parameters, traineeMapper);
			return trainee;
		}catch(Exception e){
			return null;
		}
	}

	public List<Trainee> checkAccount(LoginModel loginModel){
		try {
			String sql = "SELECT * FROM t_trainee WHERE companyName=?";
			Object[] parameters = {loginModel.getName()};
			List<Trainee> traineeList = jdbcTemplate.query(sql, parameters, traineeMapper);
			return traineeList;
		}catch(Exception e){
			return null;
		}
	}


}
