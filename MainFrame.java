import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame{
Container c;
JButton btnAdd,btnView,btnUpdate,btnDelete,btnChart;

MainFrame(){
c=getContentPane();
c.setLayout(new FlowLayout());

btnAdd=new JButton("Add");
btnView=new JButton("View");
btnUpdate=new JButton("Update");
btnDelete=new JButton("Delete");
btnChart=new JButton("Chart");

c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);
c.add(btnChart);

ActionListener a1=(ae) ->{
AddFrame af=new AddFrame();
dispose();
};
btnAdd.addActionListener(a1);

ActionListener a2=(ae) ->{
ViewFrame af=new ViewFrame();
dispose();
};
btnView.addActionListener(a2);

ActionListener a3=(ae) ->{
UpdateFrame af=new UpdateFrame();
dispose();
};
btnUpdate.addActionListener(a3);

ActionListener a4=(ae) ->{
DeleteFrame af=new DeleteFrame();
dispose();
};
btnDelete.addActionListener(a4);

ActionListener a5=(ae) ->{
ChartFrame af=new ChartFrame();
dispose();
};
btnChart.addActionListener(a5);


setTitle("S. M. S.");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

}