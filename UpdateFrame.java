import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class UpdateFrame extends JFrame{
Container c;
JLabel lblRno,lblName,lblS1,lblS2,lblS3;
JTextField txtRno,txtName,txtS1,txtS2,txtS3;
JButton btnSave,btnBack;

UpdateFrame(){
c=getContentPane();
c.setLayout(new FlowLayout());

lblRno=new JLabel("enter rno");
lblName=new JLabel("enter Name");
lblS1=new JLabel("enter Sub marks 1");
lblS2=new JLabel("enter SUb marks 2");
lblS3=new JLabel("enter Sub marks 3");

txtRno=new JTextField(15);
txtName=new JTextField(15);
txtS1=new JTextField(15);
txtS2=new JTextField(15);
txtS3=new JTextField(15);

btnSave=new JButton("Save");
btnBack=new JButton("Back");



c.add(lblRno);c.add(txtRno);
c.add(lblName);c.add(txtName);
c.add(lblS1);c.add(txtS1);
c.add(lblS2);c.add(txtS2);
c.add(lblS3);c.add(txtS3);
c.add(btnSave);c.add(btnBack);


ActionListener a1=(ae)->{
MainFrame af=new MainFrame();
dispose();
};

btnBack.addActionListener(a1);

ActionListener a2=(ae)->{
try{
int rno=Integer.parseInt(txtRno.getText());
String name=txtName.getText();
int s1=Integer.parseInt(txtS1.getText());
int s2=Integer.parseInt(txtS2.getText());
int s3=Integer.parseInt(txtS3.getText());

if((rno<1)||(name.length()<=1)||(name.isEmpty())||(s1>100) || (s1<0)||(s2>100)||(s2<0)||(s3>100)||(s3<0)){
JOptionPane.showMessageDialog(c,"u need to enter details correctly ");
txtRno.setText("");
txtRno.requestFocus();
txtName.setText("");
txtName.requestFocus();
txtS1.setText("");
txtS1.requestFocus();
txtS2.setText("");
txtS2.requestFocus();
txtS3.setText("");
txtS3.requestFocus();

}

else{
DbHandler db=new DbHandler();
db.UpdateStudent(rno,name,s1,s2,s3);
}

}catch(NumberFormatException e){
JOptionPane.showMessageDialog(c,"u need to enter numbers only ");
txtRno.setText("");
txtRno.requestFocus();
txtName.setText("");
txtName.requestFocus();
txtS1.setText("");
txtS1.requestFocus();
txtS2.setText("");
txtS2.requestFocus();
txtS3.setText("");
txtS3.requestFocus();
}
};
btnSave.addActionListener(a2);


setTitle("Update Student");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

}