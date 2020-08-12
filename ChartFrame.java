import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import java.sql.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;


class ChartFrame extends JFrame{

ChartFrame(){
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");


SessionFactory sfact=cfg.buildSessionFactory();
Session session=null;
Transaction t=null;
try{
DefaultCategoryDataset d1=new DefaultCategoryDataset();
session=sfact.openSession();
System.out.println(" connected ");

List<Student>studentlist=new ArrayList<>();
studentlist=session.createQuery("from Student").list();


for(Student s:studentlist){
	int rno=s.getRno();
	String name=s.getName();
	int s1=s.getS1();
	int s2=s.getS2();
	int s3=s.getS3();
d1.addValue(s1,name,"Phy");
d1.addValue(s2,name,"Chem");
d1.addValue(s3,name,"Maths");


}



JFreeChart chart=ChartFactory.createBarChart("Students Performance","Subjects","Marks",d1,
PlotOrientation.VERTICAL,true,false,false);

ChartPanel panel=new ChartPanel(chart);
setContentPane(panel);


setTitle("Mark Sheet");
setSize(400,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}catch(Exception e){
		System.out.println("issue "+e);
}
}
}

