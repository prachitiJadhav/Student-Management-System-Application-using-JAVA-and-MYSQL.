import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteFrame extends JFrame{
Container c;
JLabel lblRno;
JTextField txtRno;
JButton btnSave,btnBack;

DeleteFrame(){
c=getContentPane();
c.setLayout(new FlowLayout());

lblRno=new JLabel("enter rno");



txtRno=new JTextField(15);


btnSave=new JButton("Save");
btnBack=new JButton("Back");



c.add(lblRno);c.add(txtRno);

c.add(btnSave);c.add(btnBack);


ActionListener a1=(ae)->{
MainFrame af=new MainFrame();
dispose();
};

btnBack.addActionListener(a1);

ActionListener a2=(ae)->{
int rno=Integer.parseInt(txtRno.getText());

DbHandler db=new DbHandler();
db.DeleteStudent(rno);
txtRno.setText("");
txtRno.requestFocus();
};
btnSave.addActionListener(a2);


setTitle("Delete Student");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

}