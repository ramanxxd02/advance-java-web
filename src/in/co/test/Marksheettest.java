package in.co.test;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import in.co.bean.MarksheetBean;
import in.co.model.MarksheetModel;



public class Marksheettest {
	public static void main(String[] args) throws Exception {
		//testadd();
		//testupdate();
		//testdelete();
		//testidget();
		testsearch();
		
		
	}

		private static void testsearch() throws Exception {
			MarksheetBean bean = new MarksheetBean();
			MarksheetModel model = new MarksheetModel();
			List list = new ArrayList();
		   // bean.setName("Raman");
			list = model.search(null, 0, 0);
			Iterator it = list.iterator();

			while (it.hasNext()) {
				bean = (MarksheetBean) it.next();
				System.out.println("\t"+bean.getId());
				System.out.println("\t"+bean.getRollno());
				System.out.println("\t"+bean.getName());
				System.out.println("\t"+bean.getPhysics());
				System.out.println("\t"+bean.getChemistry());
				System.out.println("\t"+bean.getMaths());
				
			}
		}
		
	

	private static void testidget() throws Exception {
		MarksheetBean bean=new MarksheetBean();
//	     bean.setId(1);
//	     bean.setRollno(120);
//	     bean.setName("Yogesh");
//	     bean.setPhysics(55);
//	     bean.setChemistry(75);
//	     bean.setMaths(65);
//	     
	     MarksheetModel model=new MarksheetModel();
	   
	     bean=model.idget(5);
	     System.out.println(bean.getName());
	}

	private static void testdelete() throws Exception {
		MarksheetBean bean=new MarksheetBean();
	     bean.setId(20);
	     bean.setRollno("120");
	     bean.setName("Yogesh");
	     bean.setPhysics(55);
	     bean.setChemistry(75);
	     bean.setMaths(65);
	     
	     MarksheetModel model=new MarksheetModel();
	     model.delete(1);
	     System.out.println("done");
		
	}

	private static void testupdate() throws Exception {
		MarksheetBean bean=new MarksheetBean();
	     bean.setId(20);
	     bean.setRollno("120");
	     bean.setName("Raja");
	     bean.setPhysics(55);
	     bean.setChemistry(75);
	     bean.setMaths(65);
	     
	     MarksheetModel model=new MarksheetModel();
	     model.update(bean);
	     System.out.println("done");
		
	}

	private static void testadd() throws Exception {
		MarksheetBean bean=new MarksheetBean();
	     bean.setId(20);
	     bean.setRollno("120");
	     bean.setName("Yogesh");
	     bean.setPhysics(54);
	     bean.setChemistry(45);
	     bean.setMaths(35);
	     
	     MarksheetModel model=new MarksheetModel();
	     model.add(bean);
	     System.out.println("done");
		
	}
	
	
	

}
