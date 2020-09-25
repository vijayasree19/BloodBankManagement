package bloodbank;
import java.io.*;
import java.util.*;
 class Donor implements Serializable{
	String name,gender,group,phoneno;
	public Donor(String a,String b,String c,String d){
		name=a;
		gender=b;
		group=c;
		phoneno=d;
	}
	
	public String toString() {
		return "name is"+name+"gender :"+gender+"blood group:"+group+"phoneno"+phoneno;
	}
}

package bloodbank;
import java.awt.event.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.io.*;
import java.util.*; 
class Frame1 extends JFrame implements ActionListener  {
	
	Frame1(){
		
		super("selection bar");
		 
		setSize(500,200);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Label l= new Label("choose the appropriate option:");
		JButton donate= new JButton("donate");
		JButton accept=new JButton("accept");
		JButton displaydetail=new JButton("display");
		setLayout (new FlowLayout());
		add(l);
		add(donate);
		add(accept);
		add(displaydetail);
		donate.addActionListener(this);
		accept.addActionListener(this);
		displaydetail.addActionListener(this);
		setVisible(true);
		
	}                                                                                                 
	public static void main(String a[]) {
		new Frame1().setVisible(true);;
	}


public void actionPerformed(ActionEvent ae) {
	String option=ae.getActionCommand();
	if(option.equals("donate")) {
		Frame2 af=new Frame2();
		af.setVisible(true);
		af.setTitle("Donor");
	}else if(option.equals("accept")) {
		Frame3 f3=new Frame3();
		f3.setVisible(true);
		f3.setTitle("Accepter");
	}else {
		Frame4 f4=new Frame4();
		f4.setVisible(true);
		f4.setTitle("Accepter");
	}
}
}

public  class Frame2 extends JFrame implements ActionListener{
	TextField aa,bb,cc,dd,stat;
	FileOutputStream f1;
	ObjectOutputStream obj;
	FileInputStream f2;
	ObjectInputStream ob;
	LinkedList<Donor> li;
	Frame2(){
		 
		setSize(400,400);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		Label a=new Label("enter name");
		aa=new TextField(30);add(a);
		add(aa);
		Label b=new Label("enter gender");
		bb=new TextField(30);
		add(b);
		add(bb);
		Label c=new Label("enter group");
		cc=new TextField(30);
		add(c);
		add(cc);
		Label d=new Label("enter phone no");
		dd=new TextField(30);
		add(d);
		add(dd);
		Label r=new Label("status");
		stat=new TextField(40);
		add(r);
		add(stat);
		Button submit= new Button("submit");
		add(submit);
		submit.addActionListener(this);
		Button back= new Button("back");
		add(back);
		back.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		String s=ae.getActionCommand();
		if(s.equals("submit")) {
		try {
			f2=new FileInputStream("mydata.txt");
			ob=new ObjectInputStream(f2);	
		}catch(Exception e) {}
		try {
			li=(LinkedList<Donor>)ob.readObject();
			ob.close();
			f2.close();
		} catch (Exception e1) {
			li=new LinkedList<Donor>();
		}
		li.add(new Donor(aa.getText(),bb.getText(),cc.getText(),dd.getText()));
		
         try {
	f1=new FileOutputStream("mydata.txt");
	obj=new ObjectOutputStream(f1);
	obj.writeObject(li);
	obj.close();
	f2.close();
	}catch(Exception e) {}
		stat.setText("thanks for donating blood!!");}else {dispose();}
	}	
}

package bloodbank;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.io.*;
import java.util.*;
public  class Frame3 extends JFrame implements ActionListener{
	TextField aa,bb,cc,dd,stat;
	FileOutputStream f1;
	ObjectOutputStream obj;
	FileInputStream f2;
	ObjectInputStream ob;
	LinkedList<Donor> li;
	Frame3(){
		 
		setSize(400,400);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		Label a=new Label("enter name");
		aa=new TextField(30);add(a);
		add(aa);
		Label b=new Label("enter gender");
		bb=new TextField(30);
		add(b);
		add(bb);
		Label c=new Label("enter group");
		cc=new TextField(30);
		add(c);
		add(cc);
		Label d=new Label("enter phone no");
		dd=new TextField(30);
		add(d);
		add(dd);
		Label r=new Label("status");
		stat=new TextField(40);
		add(r);add(stat);
		Button submit= new Button("submit");
		add(submit);
		submit.addActionListener(this);
		Button back= new Button("back");
		add(back);
		back.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		String s=ae.getActionCommand();
		if(s.equals("submit")) {
		try {
			f2=new FileInputStream("mycollectordata.txt");
			ob=new ObjectInputStream(f2);	
		}
                        catch(Exception e) {}
		try
                         {
			li=(LinkedList<Donor>)ob.readObject();
			ob.close();
			f2.close();
		} 
                        catch (Exception e1) {
			li=new LinkedList<Donor>();
		}
		li.add(new Donor(aa.getText(),bb.getText(),cc.getText(),dd.getText()));
		try {
	                  f1=new FileOutputStream("mycollectiondata.txt");
	                  obj=new ObjectOutputStream(f1);
	                  obj.writeObject(li);
	                  obj.close();
	                  f2.close();
	            }
                       catch(Exception e) {}
		stat.setText("request is sent and you will get response");}
                     else {dispose();}
	
            }	
            }

package bloodbank;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.io.*;
import java.util.*;
public  class Frame4 extends JFrame implements ActionListener{
	TextField aa,bb,cc,dd,stat;
	FileInputStream f1;
	ObjectInputStream obj;
	FileInputStream f2;
	ObjectInputStream ob;
	LinkedList<Donor> li;
	Frame4(){
		 
		setSize(400,400);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		Label a=new Label("total donors");
		aa=new TextField(30);add(a);
		add(aa);
		Label b=new Label("total acceptors");
		bb=new TextField(30);
		add(b);
		add(bb);
		Label c=new Label("total donor group");
		cc=new TextField(30);
		add(c);
		add(cc);
		Label d=new Label("total acceptor group");
		dd=new TextField(30);
		add(d);
		add(dd);
		Label r=new Label("total donor blood");
		stat=new TextField(50);
		add(r);
		add(stat);
		Button submit= new Button("submit");
		add(submit);
		submit.addActionListener(this);
		Button back= new Button("back");
		add(back);
		back.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		String s=ae.getActionCommand();
		if(!s.equals("back")) {
		try {
			f2=new FileInputStream("mydata.txt");
			ob=new ObjectInputStream(f2);	
		}catch(Exception e) {}
		try {
			li=(LinkedList<Donor>)ob.readObject();
			int ap=0;
			int an=0;
			int bp=0;
			int bn=0;
			int op=0;
			int on=0;
			for(Donor i:li) {
				if(i.group.equals("A+")) {
					ap++;
				}else if(i.group.equals("A-")) {
					an++;
				}else if(i.group.equals("B-")) {
					bn++;
				}else if(i.group.equals("B+")) {
					bp++;
				}else if(i.group.equals("O-")) {
					on++;
				}else if(i.group.equals("O+")) {
					op++;
				}
			}
			aa.setText(li.size()+" ");
			cc.setText("A+ :" + ap+ " A- :"+an+" B+ :"+bp+" B- :"+bn+" O+ :"+op+" O- :"+on);
			if(li.size()>0) {
				stat.setText("there are donors available");
			}else {
				stat.setText("there no donors available");
			}
			ob.close();
			
			f2.close();
		} 
                         catch (Exception e1) {
			li=new LinkedList<Donor>();
		}
		li.add(new Donor(aa.getText(),bb.getText(),cc.getText(),dd.getText()));
		try
                         {
	                   f1=new FileInputStream("mycollectiondata.txt");
	                   obj=new ObjectInputStream(f1);
	             }
                     
                       catch(Exception e) {}
                       try {
		li=(LinkedList<Donor>)obj.readObject();
		int ap=0;
		int an=0;
		int bp=0;
		int bn=0;
		int op=0;
		int on=0;
		for(Donor i:li) {
			if(i.group.equals("A+")) {
				ap++;
			}else if(i.group.equals("A-")) {
				an++;
			}else if(i.group.equals("B-")) {
				bn++;
			}else if(i.group.equals("B+")) {
				bp++;
			}else if(i.group.equals("O-")) {
				on++;
			}else if(i.group.equals("O+")) {
				op++;
			}
		}
		bb.setText(li.size()+" ");
		dd.setText("A+ :"+ap+" A- :"+an+" B+ :"+bp+" B- :"+bn+" O+ :"+op+" O- :"+on);
		obj.close();
		f1.close();
	} catch (Exception e1) {}
	}else{dispose();}
}}
                 















