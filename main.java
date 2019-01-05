
/*p1-login
p2-student menu
p3-student choose pref
p4-coordinator menu
p5-coordinator allot    
*/                                      
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;

public class login 
{
  String suser_id,spassword,type_of_user,type_selected;
  boolean valid=false;
  char[] cpassword;
  int r;
  float newSize=30,newSize1=20;
      
  private JFrame p1,p2,p3,p4,p5,p6;
  private JPanel cp3;
  private ActionListener action_button,action_radiobutton,action_combobox;
  private ItemListener action_checkbox;

  Connection con,con2;
  Statement st,st2,st3;
  PreparedStatement pst,pst2,pst3;
  ResultSet rs,rs2,rs3;
  
  //p1
  private JLabel heading,Luser_id,Lpassword,login_as,login_result,i2;
  private JTextField user_id;
  private JPasswordField  password;
  private JRadioButton Rstudent,Rcoordinator;
  private ButtonGroup bg_login_as;
  private JButton login;
  
  //p2
  private JLabel Lstudent_menu;
  private JButton choose_electives,view_alloted,p2_logout;
  
  //p3
   private String p1_remove="",p2_remove="",p3_remove="",p4_remove="",p1_removeb="",p2_removeb="",p3_removeb="",p4_removeb="";
  private JLabel select_pref, student_allotment_done,select_prefb,lsusn,lsname,lsbranch,lssem,lssec,lselect_elec;
  private JComboBox jcb1,jcb2,jcb3,jcb4,jcbb1,jcbb2,jcbb3,jcbb4; 
  private JButton p3_back_to_menu,submit_electives;
  private String g[]={"information retrieval","internet technologies","information on demand","game theory","system simulation"};
  private String s[]={"artificial intelligence","advanced DBMS","digital signal processing","C# and.Net Technologies","pattern recognition"};
  
  //p4
  private JLabel Lcoordinator_menu;
  private JButton allot_electives,p4_logout;
  int coordinator_submit_flag=0;

  
  //p5
  private JLabel vj1,lcid,lcname,lcbranch,lcsemester,lcgroup,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,allotment_done;
  private JButton p5_back_to_menu,submit_allotment;
  private JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10;
  
  //p6
  private JLabel view_groupa,view_groupb;
  private JButton p6_back_to_menu;
  
  
  
	private static final long serialVersionUID = 1L;
	login()
	{

		
	//p1-login
	  p1=new JFrame("LOGIN");
    p1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  p1.setLayout(null);
    p1.setLocationByPlatform(true);
	  p1.setBackground(Color.white);
	  p1.setSize(1200,700);
	

   
   //i1= new JLabel(new ImageIcon("b1.jpg"));
   i2=new JLabel(new ImageIcon("b1.jpg"));
   //i1.setBounds(0,600,250,400);
   i2.setBounds(0,0,1000,200);
  
   heading = new JLabel("MSRIT ELECTIVE MANAGEMENT");
   heading.setBounds(400,250,500,50);
   heading.setFont(heading.getFont().deriveFont(newSize));
   Luser_id=new JLabel("Username : ");
   Luser_id.setBounds(400,200,300,400);
   Lpassword=new JLabel("Password : ");
   Lpassword.setBounds(400,400,350,100);
   user_id=new JTextField(15);
   user_id.setBounds(500,390,200,20);
   password=new JPasswordField(15);
   password.setBounds(500,440,200,20);
   login_as = new JLabel("Login as :");
   login_as.setBounds(400,500,100,20);
   bg_login_as=new ButtonGroup();
   Rstudent = new JRadioButton("student");
   Rstudent.setBounds(500,500,100,20);
   Rcoordinator= new JRadioButton("coordinator");
   Rcoordinator.setBounds(650,500,100,20);
   login_result=new JLabel("");
   login_result.setBounds(500,500,100,100);
   login=new JButton("Login");
   login.setBounds(500,550,100,30);
   
   //p1.add(i1);
   p1.add(i2);
   p1.add(heading);     
   p1.add(Luser_id);
   p1.add(user_id);
   p1.add(Lpassword);
   p1.add(password);
   p1.add(login_as);
   bg_login_as.add(Rstudent);
   bg_login_as.add(Rcoordinator);
   p1.add(Rstudent);
   p1.add(Rcoordinator);
   p1.add(login);
   p1.add(login_result);

   
   
  //p2-student menu 
   p2=new JFrame("MENU");
   p2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   p2.setLayout(null);
   p2.setLocationByPlatform(true);
	 p2.setBackground(Color.white);
	 p2.setSize(1200,700);
   //p2.setVisible(true);
      
   //i1= new JLabel(new ImageIcon("b1.jpg"));
   i2=new JLabel(new ImageIcon("b1.jpg"));
   //i1.setBounds(0,0,250,400);
   i2.setBounds(50,0,1000,200);
   Lstudent_menu=new JLabel("STUDENT MENU");
   Lstudent_menu.setFont(Lstudent_menu.getFont().deriveFont(newSize));
   Lstudent_menu.setBounds(450,250,500,100);
   choose_electives=new JButton("Choose Electives");
   choose_electives.setBounds(500,400,150,30);
   view_alloted=new JButton("View Alloted Electives");
  view_alloted.setBounds(500,450,200,30);
   p2_logout=new JButton("Logout");
   p2_logout.setBounds(520,500,100,30);
   
   //p2.add(i1);
   p2.add(i2);
   p2.add(Lstudent_menu);
   p2.add(choose_electives);
   p2.add(view_alloted);
   view_alloted.setEnabled(false);
   view_alloted.setVisible(false);
   p2.add(p2_logout);
   


   //p3-student choose pref
   i2=new JLabel(new ImageIcon("b1.jpg"));
   i2.setBounds(50,0,1000,200);
   p3=new JFrame("ELECTIVE PREFERENCE SELECTION");
   
   p3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   p3.setLocationByPlatform(true);
   
   cp3 = new JPanel();
   cp3.setLayout(new BoxLayout(cp3, BoxLayout.Y_AXIS));
   cp3.setAlignmentX(Component.LEFT_ALIGNMENT);
	 cp3.setBackground(Color.LIGHT_GRAY);
	 
	 lselect_elec=new JLabel("CHOOSE ELECTIVE PREFERENCES ");
	 lselect_elec.setFont(lselect_elec.getFont().deriveFont(newSize));
	 lselect_elec.setBounds(450,250,500,100);
	 
	 lsname=new JLabel("Name :  ");
	 lsusn=new JLabel("USN  :  ");
	 lsbranch=new JLabel("Branch :  ");
	 lssem=new JLabel("Semester :  ");
	 lssec=new JLabel("Section :  ");
	 
	 select_pref=new JLabel("Choose Your Electives Preferences for Group A");
	 select_pref.setFont(lselect_elec.getFont().deriveFont(newSize1));
	 jcb1 =new JComboBox(s);	
	  jcb2=new JComboBox();
	  jcb2.setEnabled(false);  
	  jcb3=new JComboBox();
	  jcb3.setEnabled(false);  
    jcb4=new JComboBox();
    jcb4.setEnabled(false);  
    select_prefb=new JLabel("Choose Your Electives Preferences for Group B");
    select_prefb.setFont(lselect_elec.getFont().deriveFont(newSize1));
    jcbb1 =new JComboBox(g);	
	  jcbb2=new JComboBox();
	  jcbb2.setEnabled(false);  
	  jcbb3=new JComboBox();
	  jcbb3.setEnabled(false);  
    jcbb4=new JComboBox();
    jcbb4.setEnabled(false);  
    p3_back_to_menu=new JButton("Back To Menu");
    submit_electives=new JButton("Submit Electives");
    student_allotment_done=new JLabel("");
    cp3.add(i2);
    cp3.add(lselect_elec);
    cp3.add(lsname);
		cp3.add(lsusn);
		cp3.add(lsbranch);
		cp3.add(lssem);
		cp3.add(lssec);
    cp3.add(select_pref);
		cp3.add(jcb1);
		cp3.add(jcb2);
		cp3.add(jcb3);
		cp3.add(jcb4);
		cp3.add(select_prefb);
		cp3.add(jcbb1);
		cp3.add(jcbb2);
		cp3.add(jcbb3);
		cp3.add(jcbb4);
	    cp3.add(p3_back_to_menu);
	    cp3.add(submit_electives);
	    cp3.add(student_allotment_done);
	 
   p3.getContentPane().add(cp3);
   p3.setSize(1000,700);
   
   
   //p4-coordinator login
   p4 = new JFrame("CO-ORDINATOR MENU");
   p4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   p4.setLayout(null);
   p4.setLocationByPlatform(true);
   p4.setBackground(Color.WHITE);
   p4.setSize(1200,700); 
   
   i2=new JLabel(new ImageIcon("b1.jpg"));
   i2.setBounds(50,0,1000,200);
   Lcoordinator_menu=new JLabel("CO-ORDINATOR MENU");
   Lcoordinator_menu.setFont(Lcoordinator_menu.getFont().deriveFont(newSize));
   Lcoordinator_menu.setBounds(450,250,500,100);
   allot_electives=new JButton("Allot Electives");
  allot_electives.setBounds(500,400,150,30);
   p4_logout=new JButton("Logout");
   p4_logout.setBounds(520,500,100,30);
   
   //p4.add(i1);
   p4.add(i2);
   p4.add(Lcoordinator_menu);
   p4.add(allot_electives);
   p4.add(p4_logout);

   //p5
   p5 =new JFrame("ELECTIVE CO-ORDINATOR ");
   p5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  p5.setLocationByPlatform(true);
   p5.setBackground(Color.WHITE);
   p5.setSize(1200,800); 
   
  
   i2=new JLabel(new ImageIcon("b1.jpg"));
   i2.setBounds(50,0,1000,200);
   //p5.add(i1);
   p5.add(i2);
   vj1=new JLabel("ELECTIVE CO-ORDINATOR");vj1.setFont(vj1.getFont().deriveFont(newSize));
   vj1.setBounds(450,150,500,100);p5.add(vj1);
	 lcid=new JLabel("ID  :  "); lcid.setBounds(400,200,150,100);p5.add(lcid);
	 lcname=new JLabel("Name  :  ");lcname.setBounds(400,220,150,100);p5.add(lcname);
	 lcbranch=new JLabel("Branch  :  ");lcbranch.setBounds(400,240,150,100);p5.add(lcbranch);
	 
	lcsemester=new JLabel("SEMESTER  5");lcsemester.setBounds(400,270,150,100);p5.add(lcsemester);
	lcgroup=new JLabel("GROUP  A  ");lcgroup.setBounds(400,290,150,100);p5.add(lcgroup);
	
	vj1=new JLabel("P1  ");vj1.setBounds(440,330,500,100);p5.add(vj1);
	vj1=new JLabel("P2  ");vj1.setBounds(480,330,500,100);p5.add(vj1);
  vj1=new JLabel("P3  ");vj1.setBounds(520,330,500,100);p5.add(vj1);
	vj1=new JLabel("P4  ");vj1.setBounds(560,330,500,100);p5.add(vj1);

	s1=new JLabel("artificial intelligence");s1.setBounds(250,350,500,100);p5.add(s1); 
  cb1=new JCheckBox("");cb1.setBounds(590,380,20,20);p5.add(cb1);
	s2=new JLabel("advanced DBMS");s2.setBounds(250,370,500,100);p5.add(s2);
	cb2=new JCheckBox("");cb2.setBounds(590,400,20,20);p5.add(cb2);
  s3=new JLabel("digital signal processing"); s3.setBounds(250,390,500,100);p5.add(s3);
  cb3=new JCheckBox("");cb3.setBounds(590,420,20,20);p5.add(cb3);
	s4=new JLabel("C# and.Net Technologies");s4.setBounds(250,410,500,100);p5.add(s4);
	cb4=new JCheckBox("");cb4.setBounds(590,440,20,20);p5.add(cb4);
	s5=new JLabel("pattern recognition");s5.setBounds(250,430,500,100);p5.add(s5);
	cb5=new JCheckBox("");cb5.setBounds(590,460,20,20);p5.add(cb5);
	
	
	lcsemester=new JLabel("SEMESTER  5");lcsemester.setBounds(700,270,150,100);p5.add(lcsemester);
	lcgroup=new JLabel("GROUP B  ");lcgroup.setBounds(700,290,150,100);p5.add(lcgroup);
	 
	vj1=new JLabel("P1  ");vj1.setBounds(820,330,500,100);p5.add(vj1);
	vj1=new JLabel("P2  ");vj1.setBounds(860,330,500,100);p5.add(vj1);
	vj1=new JLabel("P3  ");vj1.setBounds(900,330,500,100);p5.add(vj1);
	vj1=new JLabel("P4  ");vj1.setBounds(940,330,500,100);p5.add(vj1);
	 
	s6=new JLabel("information retrieval");s6.setBounds(650,350,500,100);p5.add(s6); 
  cb6=new JCheckBox("");cb6.setBounds(990,380,20,20);p5.add(cb6);
	s7=new JLabel("internet technologies");s7.setBounds(650,370,500,100);p5.add(s7);
	cb7=new JCheckBox("");cb7.setBounds(990,400,20,20);p5.add(cb7);
  s8=new JLabel("information on demand");s8.setBounds(650,390,500,100);p5.add(s8);
  cb8=new JCheckBox("");cb8.setBounds(990,420,20,20);p5.add(cb8);
	s9=new JLabel("game theory");s9.setBounds(650,410,500,100);p5.add(s9);
	cb9=new JCheckBox("");cb9.setBounds(990,440,20,20);p5.add(cb9);
	s10=new JLabel("system simulation");s10.setBounds(650,430,500,100);p5.add(s10);
	cb10=new JCheckBox("");cb10.setBounds(990,460,20,20);p5.add(cb10);
	

	submit_allotment=new JButton("Submit Allotment");submit_allotment.setBounds(500,530,150,30);p5.add(submit_allotment);
	p5_back_to_menu=new JButton("Back to Menu");p5_back_to_menu.setBounds(750,530,150,30);p5.add(p5_back_to_menu);
	allotment_done=new JLabel("");allotment_done.setBounds(500,590,100,100);p5.add(allotment_done);
	
//p6
  p6 =new JFrame("VIEW ALLOTMENT");
  p6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  p6.setLocationByPlatform(true);
  p6.setLayout(null);
  p6.setBackground(Color.WHITE);
  p6.setSize(1200,900); 
  i2=new JLabel(new ImageIcon("b1.jpg"));
  i2.setBounds(50,0,1000,200);
  vj1=new JLabel("VIEW ALLOTED ELECTIVES");vj1.setFont(vj1.getFont().deriveFont(newSize));
  vj1.setBounds(450,150,500,100);p6.add(vj1);
   lsusn=new JLabel("USN  :  ");lsusn.setBounds(400,300,300,10);
	 lsname=new JLabel("Name :  ");lsname.setBounds(400,340,300,10);
	 lsbranch=new JLabel("Branch :  ");lsbranch.setBounds(400,380,300,10);
	 lssem=new JLabel("Semester :  ");lssem.setBounds(400,420,300,10);
	 lssec=new JLabel("Section :  ");lssec.setBounds(400,460,300,10);
  view_groupa=new JLabel("GROUP A  :  "); view_groupa.setBounds(400,500,300,10);
  view_groupb=new JLabel("GROUP B  :  ");view_groupb.setBounds(400,540,300,10);
  p6_back_to_menu=new JButton("Back to menu");p6_back_to_menu.setBounds(500,600,150,30);
  
 // p6.add(i1);
  p6.add(i2);
  p6.add(vj1);
  p6.add(lsname);
	p6.add(lsusn);
	p6.add(lsbranch);
	p6.add(lssem);
	p6.add(lssec);
	p6.add(view_groupa);
	p6.add(view_groupb);
	p6.add(p6_back_to_menu);
	
	p1.setVisible(true);
	
	
   action_button  = new ActionListener()
   {
       public void actionPerformed(ActionEvent ae)
       {
         
 		  //p1
      	if ((JButton)ae.getSource()==login)
      	 {
           valid=false;
      	 suser_id=user_id.getText();
		     cpassword=password.getPassword();
 		     spassword=null;
           spassword=String.copyValueOf(cpassword);
           try
           {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbs_project","root","root");
            pst=con.prepareStatement("select * from login where user_id=? and password=? and type_of_user=?");
            pst.setString(1,suser_id); 
            pst.setString(2,spassword);
            pst.setString(3,type_selected);
            rs=pst.executeQuery();
            while(rs.next())
            {
               valid=true;
               type_of_user=rs.getString(3);
            }
           if(valid==true&&(type_of_user.equals("student")))
          
             {
          	 try{
                   Class.forName("com.mysql.jdbc.Driver");
                   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/7thsem","root","root");
                   pst=con.prepareStatement("Select csubmit from student,coordinator where sbranch=cbranch and suser_id=?");
                   pst.setString(1,suser_id);
                   rs=pst.executeQuery();
                   rs.next();
                   coordinator_submit_flag=Integer.parseInt(rs.getString(1));
                   if(coordinator_submit_flag==1)
                   {
                  	 view_alloted.setEnabled(true);
                  	 view_alloted.setVisible(true);
                   }
      		 }
      		  catch (ClassNotFoundException e) {System.out.println("Could not find the database driver");} 
                catch (SQLException e) {System.out.println("Could not connect to the database");} 
                
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbs_project","root","root");
                    pst=con.prepareStatement("Select usn,sfname,sminit,slname,sbranch,ssem,sec,group_a,group_b from student where suser_id=?");
                    pst.setString(1,suser_id);
                    rs=pst.executeQuery();
                    while(rs.next())
                    {
                    	 lsusn.setText(lsusn.getText()+"  "+rs.getString(1));
                    	lsname.setText(lsname.getText()+"    "+rs.getString(2)+"    "+rs.getString(3)+"    "+rs.getString(4));
                    	lsbranch.setText(lsbranch.getText()+"    "+rs.getString(5));
                    	lssem.setText(lssem.getText()+"    "+rs.getString(6));
                    	lssec.setText(lssec.getText()+"    "+rs.getString(7));
                    	view_groupa.setText(view_groupa.getText()+"    "+rs.getString(8));
                  	view_groupb.setText(view_groupb.getText()+"    "+rs.getString(9));
                    }
       		 }
       		  catch (ClassNotFoundException e) {System.out.println("Could not find the database driver");} 
                 catch (SQLException e) {System.out.println("Could not connect to the database");} 
                    
      	
          	  p1.setVisible(false);
                p2.setVisible(true);
               }
            else   if(valid==true&&(type_of_user.equals("coordinator")))
            {
          	  p1.setVisible(false);
                p4.setVisible(true); 
            }
             else
          	   login_result.setText("Invalid Username or Password!!");
          	
             }
           
             catch (ClassNotFoundException e) {System.out.println("Could not find the database driver");} 
             catch (SQLException e) {System.out.println("Could not connect to the database");}
        }
 		  
 		  //p2
      	 else if ((JButton)ae.getSource() == choose_electives)
      	 {
      		       		 
      		 p2.setVisible(false);
               p3.setVisible(true);
      	
      	 }
      	else if ((JButton)ae.getSource() == view_alloted)
      	{
      		p6.setVisible(true);
      		p2.setVisible(false);
      	}
      	 else if ((JButton)ae.getSource() == p2_logout)
      	 {
      		 p2.setVisible(false);
               p1.setVisible(true);
               login_result.setText("You have logged out succesfully!!");
      	 }
      	 //p3
      	else if ((JButton)ae.getSource() == submit_electives)
      	 {
      		 try{
                   Class.forName("com.mysql.jdbc.Driver");
                   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbs_project","root","root");
                  
              //for group A  
              String query = "INSERT INTO group_a(gausn, 1st_pref, 2nd_pref, 3rd_pref,4th_pref) VALUES "+"('"+suser_id+"', '" + p1_remove +"', '" + p2_remove +"', '" + p3_remove +"', '" + p4_remove + "')";
              Statement stmt = con.createStatement();
              stmt.executeUpdate(query); 
              stmt.close();
          
                 }
                   catch (ClassNotFoundException e) {System.out.println("Could not find the database driver");} 
                   catch (SQLException e) {System.out.println("Could not connect to the database");} 
                   try{
                       Class.forName("com.mysql.jdbc.Driver");
                       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbs_project","root","root");
                  
                  //for group B
                  String query1 = "INSERT INTO group_b(gbusn, 1st_pref, 2nd_pref, 3rd_pref,4th_pref) VALUES "+"('"+suser_id+"', '" + p1_removeb +"', '" + p2_removeb +"', '" + p3_removeb +"', '" + p4_removeb + "')";
              
              Statement stmt1 = con.createStatement();
              stmt1.executeUpdate(query1); 
              stmt1.close();
              
               }
                       catch (ClassNotFoundException e) {System.out.println("Could not find the database driver");} 
                       catch (SQLException e) {System.out.println("Could not connect to the database");} 
                       student_allotment_done.setText("The selected electives have been registered successfully!!");
      	 }
      	
      	 else if((JButton)ae.getSource()==p3_back_to_menu)
      	 {
      		 p3.setVisible(false);
               p2.setVisible(true);
      	 }
      	 //p4
      	 
      	 else if ((JButton)ae.getSource() ==allot_electives )
      	 {
      		 
      		 try{
                   Class.forName("com.mysql.jdbc.Driver");
                   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbs_project","root","root");
                   st=con.createStatement();
       
                   pst=con.prepareStatement("Select cid,cname,cbranch from coordinator where cuser_id=?");
                   pst.setString(1,suser_id);
                   rs=pst.executeQuery();
                   while(rs.next())
                   {
                   	 lcid.setText(lcid.getText()+"    "+rs.getString(1));
                   	lcname.setText(lcname.getText()+"    "+rs.getString(2));
                   	lcbranch.setText(lcbranch.getText()+"    "+rs.getString(3));
                   }
                   
                   //group a
                  
                   rs=st.executeQuery("Select count(*) from group_a where 1st_pref='artificial intelligence'");
                   {
                     rs.next();
                     s1.setText(s1.getText()+"                        "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_a where 2nd_pref='artificial intelligence'");
                   {
                     rs.next();
                     s1.setText(s1.getText()+"           "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_a where 3rd_pref='artificial intelligence'");
                   {
                     rs.next();
                     s1.setText(s1.getText()+"            "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_a where 4th_pref='artificial intelligence'");
                   {
                     rs.next();
                     s1.setText(s1.getText()+"             "+rs.getString(1));
                   } 
                   rs=st.executeQuery("Select count(*) from group_a where 1st_pref='advanced DBMS'");
                   {
                       rs.next();
                       s2.setText(s2.getText()+"                             "+rs.getString(1));
                     }
                   rs=st.executeQuery("Select count(*) from group_a where 2nd_pref='advanced DBMS'");
                   {
                     rs.next();
                     s2.setText(s2.getText()+"              "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_a where 3rd_pref='advanced DBMS'");
                   {
                     rs.next();
                     s2.setText(s2.getText()+"           "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_a where 4th_pref='advanced DBMS'");
                   {
                     rs.next();
                     s2.setText(s2.getText()+"           "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_a where 1st_pref='digital signal processing'");
                   {
                     rs.next();
                     s3.setText(s3.getText()+"                  "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_a where 2nd_pref='digital signal processing'");
                   {
                     rs.next();
                     s3.setText(s3.getText()+"           "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_a where 3rd_pref='digital signal processing'");
                   {
                     rs.next();
                     s3.setText(s3.getText()+"           "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_a where 4th_pref='digital signal processing'");
                   {
                     rs.next();
                     s3.setText(s3.getText()+"           "+rs.getString(1));
                   }
                  
                   rs=st.executeQuery("Select count(*) from group_a where 1st_pref='C# and.Net Technologies'");
                   {
                     rs.next();
                     s4.setText(s4.getText()+"                 "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_a where 2nd_pref='C# and.Net Technologies'");
                   {
                     rs.next();
                     s4.setText(s4.getText()+"           "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_a where 3rd_pref='C# and.Net Technologies'");
                   {
                     rs.next();
                     s4.setText(s4.getText()+"           "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_a where 4th_pref='C# and.Net Technologies'");
                   {
                     rs.next();
                     s4.setText(s4.getText()+"           "+rs.getString(1));
                   }
                   
                   rs=st.executeQuery("Select count(*) from group_a where 1st_pref='pattern recognition'");
                   {
                     rs.next();
                     s5.setText(s5.getText()+"                       "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_a where 2nd_pref='pattern recognition'");
                   {
                     rs.next();
                     s5.setText(s5.getText()+"           "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_a where 3rd_pref='pattern recognition'");
                   {
                     rs.next();
                     s5.setText(s5.getText()+"           "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_a where 4th_pref='pattern recognition'");
                   {
                     rs.next();
                     s5.setText(s5.getText()+"           "+rs.getString(1));
                   }
                   
                   //GROUP B
                   rs=st.executeQuery("Select count(*) from group_b where 1st_pref='information retrieval'");
                   {
                     rs.next();
                     s6.setText(s6.getText()+"                        "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_b where 2nd_pref='information retrieval'");
                   {
                     rs.next();
                     s6.setText(s6.getText()+"           "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_b where 3rd_pref='information retrieval'");
                   {
                     rs.next();
                     s6.setText(s6.getText()+"           "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_b where 4th_pref='information retrieval'");
                   {
                     rs.next();
                     s6.setText(s6.getText()+"           "+rs.getString(1));
                   } 
                   rs=st.executeQuery("Select count(*) from group_b where 1st_pref='internet technologies'");
                   {
                       rs.next();
                       s7.setText(s7.getText()+"                        "+rs.getString(1));
                     }
                   rs=st.executeQuery("Select count(*) from group_b where 2nd_pref='internet technologies'");
                   {
                     rs.next();
                     s7.setText(s7.getText()+"           "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_b where 3rd_pref='internet technologies'");
                   {
                     rs.next();
                     s7.setText(s7.getText()+"           "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_b where 4th_pref='internet technologies'");
                   {
                     rs.next();
                     s7.setText(s7.getText()+"           "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_b where 1st_pref='information on demand'");
                   {
                     rs.next();
                     s8.setText(s8.getText()+"                    "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_b where 2nd_pref='information on demand'");
                   {
                     rs.next();
                     s8.setText(s8.getText()+"           "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_b where 3rd_pref='information on demand'");
                   {
                     rs.next();
                     s8.setText(s8.getText()+"           "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_b where 4th_pref='information on demand'");
                   {
                     rs.next();                       
                     s8.setText(s8.getText()+"           "+rs.getString(1));
                   }
                  
                   rs=st.executeQuery("Select count(*) from group_b where 1st_pref='game theory'");
                   {
                     rs.next();
                     s9.setText(s9.getText()+"                               "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_b where 2nd_pref='game theory'");
                   {
                     rs.next();
                     s9.setText(s9.getText()+"           "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_b where 3rd_pref='game theory'");
                   {
                     rs.next();
                     s9.setText(s9.getText()+"           "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_b where 4th_pref='game theory'");
                   {
                     rs.next();
                     s9.setText(s9.getText()+"           "+rs.getString(1));
                   }
                   
                   rs=st.executeQuery("Select count(*) from group_b where 1st_pref='system simulation'");
                   {
                     rs.next();
                     s10.setText(s10.getText()+"                         "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_b where 2nd_pref='system simulation'");
                   {
                     rs.next();
                     s10.setText(s10.getText()+"           "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_b where 3rd_pref='system simulation'");
                   {
                     rs.next();
                     s10.setText(s10.getText()+"           "+rs.getString(1));
                   }
                   rs=st.executeQuery("Select count(*) from group_b where 4th_pref='system simulation'");
                   {
                     rs.next();
                     s10.setText(s10.getText()+"           "+rs.getString(1));
                   }
                   p4.setVisible(false);
                   p5.setVisible(true);
                   
                   
                   
                 }
                   catch (ClassNotFoundException e) {System.out.println("Could not find the database driver");} 
                   catch (SQLException e) {System.out.println("Could not connect to the database");}
           }
      	 
      	 else if ((JButton)ae.getSource() == p4_logout)
      	 {
      		 p4.setVisible(false);
               p1.setVisible(true);
            
               login_result.setText("You have logged out succesfully!!");
      	 }
      	//p5
      	else if((JButton)ae.getSource()==submit_allotment)
     	 {
   
             try{
                 Class.forName("com.mysql.jdbc.Driver");
                 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbs_project","root","root");
                 pst=con.prepareStatement("UPDATE coordinator SET csubmit=1 where cuser_id=?");
                 pst.setString(1,suser_id);
                 r=pst.executeUpdate();
                 
                 st=con.createStatement();
                 String usn,pref1,pref2;
                 rs=st.executeQuery("Select usn,1st_pref,2nd_pref from student,group_a where usn=gausn");
        			while(rs.next())
        			{
        			 
        				usn=rs.getString(1);
        				pref1=rs.getString(2);
        				pref2=rs.getString(3);
        				//System.out.print("\n"+usn+"   "+pref1+"   "+pref2);
        				 if(cb1.isSelected()&&pref1.equals("artificial intelligence"))
        				 {
        				     pst=con.prepareStatement("Update student set group_A='artificial intelligence' where usn=?");
        			         pst.setString(1,usn);
        		            r=pst.executeUpdate();
        			     }
        				if(cb2.isSelected()&&pref1.equals("advanced DBMS"))
       				 {
       				     pst=con.prepareStatement("Update student set group_A='advanced DBMS' where usn=?");
       			         pst.setString(1,usn);
       		           r=pst.executeUpdate();
       			     }
        				if(cb3.isSelected()&&pref1.equals("digital signal processing"))
       				 {
       				     pst=con.prepareStatement("Update student set group_A='digital signal processing' where usn=?");
       			         pst.setString(1,usn);
       		           r=pst.executeUpdate();
       			     }
        				if(cb4.isSelected()&&pref1.equals("C# and.Net Technologies"))
       				 {
       				     pst=con.prepareStatement("Update student set group_A='C# and.Net Technologies' where usn=?");
       			         pst.setString(1,usn);
       		            r=pst.executeUpdate();
       			     }
        				if(cb5.isSelected()&&pref1.equals("pattern recognition"))
       				 {
       				     pst=con.prepareStatement("Update student set group_A='pattern recognition' where usn=?");
       			         pst.setString(1,usn);
       		            r=pst.executeUpdate();
       			     } 
            
        				pst2=con.prepareStatement("Select group_A from student where usn=? ");
              	    pst2.setString(1,usn);
              	    rs2=pst2.executeQuery();
              	    while(rs2.next())
              	    {
                         String s=rs2.getString(1);
              	    	if(s==null)
                           {
              		 	
               			     pst3=con.prepareStatement("Update student set group_A='"+pref2+"' where usn=?");
             			         pst3.setString(1,usn);
             		             r=pst3.executeUpdate();
               				}
                         }
        			  }
        			
        			
        			//GROUPB
        			st=con.createStatement();
                  rs=st.executeQuery("Select usn,1st_pref,2nd_pref from student,group_b where usn=gbusn");
         			while(rs.next())
         			{
         			 
         				usn=rs.getString(1);
         				pref1=rs.getString(2);
         				pref2=rs.getString(3);
         				System.out.print("\n"+usn+"   "+pref1+"   "+pref2);
         				 if(cb6.isSelected()&&pref1.equals("information retrieval"))
         				 {
         				     pst=con.prepareStatement("Update student set group_B='information retrieval' where usn=?");
         			         pst.setString(1,usn);
         		             r=pst.executeUpdate();
         			     }
         				if(cb7.isSelected()&&pref1.equals("internet technologies"))
        				 {
        				     pst=con.prepareStatement("Update student set group_B='internet technologies' where usn=?");
        			         pst.setString(1,usn);
        		           r=pst.executeUpdate();
        			     }
         				if(cb8.isSelected()&&pref1.equals("information on demand"))
        				 {
        				     pst=con.prepareStatement("Update student set group_B='information on demand' where usn=?");
        			         pst.setString(1,usn);
        		           r=pst.executeUpdate();
        			     }
         				if(cb9.isSelected()&&pref1.equals("game theory"))
        				 {
        				     pst=con.prepareStatement("Update student set group_B='game theory' where usn=?");
        			         pst.setString(1,usn);
        		            r=pst.executeUpdate();
        			     }
         				if(cb10.isSelected()&&pref1.equals("system simulation"))
        				 {
        				     pst=con.prepareStatement("Update student set group_B='system simulation' where usn=?");
        			         pst.setString(1,usn);
        		            r=pst.executeUpdate();
        			     } 
         			
         			   pst2=con.prepareStatement("Select group_B from student where usn=? ");
               	    pst2.setString(1,usn);
               	    rs2=pst2.executeQuery();
               	   
               	    while(rs2.next())
               	    {
                          System.out.print("\n"+rs2.getString(1));
                          String s=rs2.getString(1);
               	    	if(s==null)
                            {
 
                			        pst3=con.prepareStatement("Update student set group_B='"+pref2+"' where usn=?");
              			         pst3.setString(1,usn);
              		             r=pst3.executeUpdate();
                			 }      
               	    }
         			  }
     
                 }
                 catch (ClassNotFoundException e) {System.out.println("hCould not find the database driver");} 
                 catch (SQLException e) {System.out.println("hhCould not connect to the database");}
                 allotment_done.setText("The selected electives have been alloted to the students succesfully.");
                 
     	 }
      	else if((JButton)ae.getSource()==p5_back_to_menu)
     	 {
     		     p5.setVisible(false);
               p4.setVisible(true);
     	 }
         //p6 
      	else if((JButton)ae.getSource()==p6_back_to_menu)
      	{
         		p6.setVisible(false);
      		p2.setVisible(true);
      	}
       }
   }; 
  
   action_radiobutton  = new ActionListener()
   {
       public void actionPerformed(ActionEvent ae)
       {
          if ((JRadioButton)ae.getSource() == Rstudent )type_selected=ae.getActionCommand();
          if ((JRadioButton)ae.getSource() == Rcoordinator )type_selected=ae.getActionCommand();
   			 
       }
     }; 
   
     
      //getActionCommand for JComboBox is : comboBoxChanged
     action_combobox  = new ActionListener()
     {
         //p3
  	   public void actionPerformed(ActionEvent ae)
         {
           
        	if ((JComboBox)ae.getSource() == jcb1 )
        	{
        	
        		JLabel temp=new JLabel();
        		temp.setText(""+((JComboBox)ae.getSource()).getSelectedItem());
        		p1_remove=temp.getText();
        		
        		
        		jcb2.setEnabled(true);  
              jcb2.removeAllItems(); 
              for (int i = 0; i < s.length; i++) { 
              	if(!(s[i].equalsIgnoreCase(p1_remove)))
        			{
                  jcb2.addItem(s[i]); 
              }
        		}
        	}
        		
        	if ((JComboBox)ae.getSource() == jcb2 )
        	{
        		
        		JLabel temp1=new JLabel();
        		temp1.setText(""+((JComboBox)ae.getSource()).getSelectedItem());
        		p2_remove=temp1.getText();
        		jcb3.setEnabled(true);  
              jcb3.removeAllItems(); 
              for (int i = 0; i < s.length; i++) { 
              	if(((s[i].equalsIgnoreCase(p2_remove))||(s[i].equalsIgnoreCase(p1_remove)))){}
              	else
        			{
                  jcb3.addItem(s[i]); 
        			}
              }
        		
        	}
        	if ((JComboBox)ae.getSource() == jcb3 )
        	{
        		JLabel temp3=new JLabel();
        		temp3.setText(""+((JComboBox)ae.getSource()).getSelectedItem());
        		p3_remove=temp3.getText();
        		jcb4.setEnabled(true);  
              jcb4.removeAllItems(); 
              for (int i = 0; i < s.length; i++) { 
              	if(((s[i].equalsIgnoreCase(p2_remove))||(s[i].equalsIgnoreCase(p1_remove))||(s[i].equalsIgnoreCase(p3_remove)))){}
              	else
        			{
                  jcb4.addItem(s[i]); 
        			}
              }
        	}	
        	if ((JComboBox)ae.getSource() == jcb4 )
        	{
        		JLabel temp4=new JLabel();
        		temp4.setText(""+((JComboBox)ae.getSource()).getSelectedItem());
        		p4_remove=temp4.getText();
        	}	
        		 
         
  	   
  	   
  	   //for group B
  		if ((JComboBox)ae.getSource() == jcbb1 )
        	{
        	
        		JLabel temp5=new JLabel();
        		temp5.setText(""+((JComboBox)ae.getSource()).getSelectedItem());
        		p1_removeb=temp5.getText();
        		
        		
        	
        		jcbb2.setEnabled(true);  
              jcbb2.removeAllItems(); 
              for (int i = 0; i < g.length; i++) { 
              	if(!(g[i].equalsIgnoreCase(p1_removeb)))
        			{
                  jcbb2.addItem(g[i]); 
              }
        		}
        	}
        		
        	if ((JComboBox)ae.getSource() == jcbb2 )
        	{
        		
        		JLabel temp6=new JLabel();
        		temp6.setText(""+((JComboBox)ae.getSource()).getSelectedItem());
        		p2_removeb=temp6.getText();
        		
        		jcbb3.setEnabled(true);  
              jcbb3.removeAllItems(); 
              for (int i = 0; i < g.length; i++) { 
              	

 if(((g[i].equalsIgnoreCase(p2_removeb))||(g[i].equalsIgnoreCase(p1_removeb)))){}
              	else
        			{
                  jcbb3.addItem(g[i]); 
        			}
              }
        		
        	}
        	if ((JComboBox)ae.getSource() == jcbb3 )
        	{
        		JLabel temp7=new JLabel();
        		temp7.setText(""+((JComboBox)ae.getSource()).getSelectedItem());
        		p3_removeb=temp7.getText();
        		
        		jcbb4.setEnabled(true);  
              jcbb4.removeAllItems(); 
              for (int i = 0; i < g.length; i++) { 
              	

if(((g[i].equalsIgnoreCase(p2_removeb))||(g[i].equalsIgnoreCase(p1_removeb))||(g[i].equalsIgnoreCase

(p3_removeb)))){}
              	else
        			{
                  jcbb4.addItem(g[i]); 
        			}
              }
        	}	
        	if ((JComboBox)ae.getSource() == jcbb4 )
        	{
        		JLabel temp8=new JLabel();
        		temp8.setText(""+((JComboBox)ae.getSource()).getSelectedItem());
        		p4_removeb=temp8.getText();
        		
        	 }	
        	}
       }; 
       action_checkbox =new ItemListener()
       {
      	public void itemStateChanged(ItemEvent ie)
      	{
      		if((JCheckBox)ie.getItem()==cb1){}
      		if((JCheckBox)ie.getItem()==cb2){}
      		if((JCheckBox)ie.getItem()==cb3){}
      		if((JCheckBox)ie.getItem()==cb4){}
      		if((JCheckBox)ie.getItem()==cb4){}
      	}
       };
 		

 //for action listener
   
   //p1
   login.addActionListener(action_button);
   Rstudent.addActionListener(action_radiobutton);
   Rcoordinator.addActionListener(action_radiobutton);
   
   //p2
   choose_electives.addActionListener(action_button);
   view_alloted.addActionListener(action_button);
   p2_logout.addActionListener(action_button);
   
   //p3
	jcb1.addActionListener(action_combobox);
	jcb2.addActionListener(action_combobox);
	jcb3.addActionListener(action_combobox);
	jcb4.addActionListener(action_combobox);
	jcbb1.addActionListener(action_combobox);
	jcbb2.addActionListener(action_combobox);
	jcbb3.addActionListener(action_combobox);
	jcbb4.addActionListener(action_combobox);
	
  p3_back_to_menu.addActionListener(action_button);
  submit_electives.addActionListener(action_button);
  

  //p4
   allot_electives.addActionListener(action_button);
   p4_logout.addActionListener(action_button);
    
   //p5
   p5_back_to_menu.addActionListener(action_button);
   submit_allotment.addActionListener(action_button);
   cb1.addItemListener(action_checkbox);
   cb2.addItemListener(action_checkbox);
   cb3.addItemListener(action_checkbox);
   cb4.addItemListener(action_checkbox);
   cb5.addItemListener(action_checkbox);
   
   //p6
   p6_back_to_menu.addActionListener(action_button);
   
   
             
 }
	public static void main(String args[])
  {
     
      SwingUtilities.invokeLater(new Runnable()
      {
          public void run()
          {
              new login();
          }
      });
  }
}

                
    

            
