import java.sql.*;
import javax.swing.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;


class DbHandler{

public static void addStudent(int rno,String name,int s1,int s2, int s3){
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");


SessionFactory sfact=cfg.buildSessionFactory();
Session session=null;
Transaction t=null;

try{
session=sfact.openSession();
System.out.println(" connected ");

t=session.beginTransaction();


Student s=new Student(rno,name,s1,s2,s3);
session.save(s);
t.commit();
JOptionPane.showMessageDialog(new JDialog(),"record inserted ");



}catch(Exception e){
JOptionPane.showMessageDialog(new JDialog(),"issue "+e);
t.rollback();
}finally{
	if (session!=null){
		session.close();
		System.out.println(" disconnected ");
	}
}



}

public static String viewStudent(){
String data="";

Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact=cfg.buildSessionFactory();
Session session=null;



try{



session=sfact.openSession();
System.out.println(" connected ");


List<Student>studentlist=new ArrayList<>();
studentlist=session.createQuery("from Student").list();

for(Student s:studentlist){
	data=data+"rno "+s.getRno()+" name: "+s.getName()+" s1: "+s.getS1()+" s2: "+s.getS2()+" s3 "+s.getS3()+"\n";


}
}catch(Exception e){
JOptionPane.showMessageDialog(new JDialog(),"issue "+e);
}finally{
	
	if (session!=null){
		session.close();
		System.out.println(" disconnected ");
	}
return data;
}

}


public static void UpdateStudent(int rno,String name,int s1,int s2, int s3){
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");


SessionFactory sfact=cfg.buildSessionFactory();
Session session=null;
Transaction t=null;

try{
session=sfact.openSession();
System.out.println(" connected ");

t=session.beginTransaction();


Student s=(Student)session.get(Student.class,rno);
if(s==null){
JOptionPane.showMessageDialog(new JDialog(),"not found");


}else{
s.setName(name);
s.setS1(s1);
s.setS2(s2);
s.setS3(s3);
session.save(s);
t.commit();
JOptionPane.showMessageDialog(new JDialog(),"record updated ");



}


}catch(Exception e){
JOptionPane.showMessageDialog(new JDialog(),"issue "+e);
t.rollback();
}finally{
	if (session!=null){
		session.close();
		System.out.println(" disconnected ");
	}
}



}

public static void DeleteStudent(int rno){
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");


SessionFactory sfact=cfg.buildSessionFactory();
Session session=null;
Transaction t=null;

try{
session=sfact.openSession();
System.out.println(" connected ");

t=session.beginTransaction();


Student s=(Student)session.get(Student.class,rno);
if(s==null){
JOptionPane.showMessageDialog(new JDialog(),"not found");


}else{
session.delete(s);
t.commit();
JOptionPane.showMessageDialog(new JDialog(),"record deleted ");



}


}catch(Exception e){
JOptionPane.showMessageDialog(new JDialog(),"issue "+e);
t.rollback();
}finally{
	if (session!=null){
		session.close();
		System.out.println(" disconnected ");
	}
}



}
}
