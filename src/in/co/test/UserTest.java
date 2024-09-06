package in.co.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.bean.UserBean;
import in.co.model.UserModel;

public class UserTest{
	public static void main(String[] args) throws Exception {
		//testadd();
		//testupdate();
		//testdelete();
		 //testsearch();
		//testauth();
		testfindByPK();
	}

	private static void testfindByPK() {
		
		
	}

	private static void testauth() throws Exception {
		UserModel model = new UserModel();

		UserBean bean = model.authenticate("raman@gmail.com", "123");

		if (bean != null) {

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());

		} else {
			System.out.println("login id & password is invalid...!!");
		}
		
	}

	private static void testsearch() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		UserBean bean = new UserBean();
		// bean.setFirstName("a");
		// bean.setDob(sdf.parse("02/04/2001"));

		UserModel model = new UserModel();

		List list = model.search(bean, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (UserBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());
		}
		
	}

	private static void testdelete() throws Exception {
		UserModel model = new UserModel();

		UserBean existBean = model.findByPk(3);

		if (existBean != null) {
			model.delete(existBean.getId());
		} else {
			System.out.println("Id not found...!!!");
		}

		
	}

	private static void testupdate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		UserModel model = new UserModel();
		UserBean bean =model.findByPk(1);
		bean.setId(1);
		bean.setFirstName("raman");
		bean.setLastName("dange");
		bean.setLoginId("raman@gmail.com");
		bean.setPassword("123");
		bean.setDob(sdf.parse("02/04/2001"));
		bean.setAddress("indore");
		
		
		
		model.update(bean);
	}

	private static void testadd() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		UserBean bean = new UserBean();
		bean.setFirstName("mno");
		bean.setLastName("zyx");
		bean.setLoginId("xyzw@gmail.com");
		bean.setPassword("1234");
		bean.setDob(sdf.parse("11/11/2022"));
		bean.setAddress("indore");

		UserModel model = new UserModel();

		try {
			model.add(bean);
		} catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
		}

	}
		
	}


