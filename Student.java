import java.awt.*;
import java.awt.event.*;

class Student extends Frame implements ActionListener
{
	Label lsname, lsrollno, lsclass, lgander, lsbg, lsmob, lsadrs;
	CheckboxGroup gander;
	Checkbox male, female, trainpass;
	Choice csclass;
	TextField tfsname, tfsrollno, tfsmob;
	TextArea tasadrs;
	Button submit;

	TextArea display_details;

	Student()
	{
		lsname   = new Label("Name : ");
		lsrollno = new Label("Roll No : ");
		lsclass  = new Label("Class : ");
		lgander  = new Label("Gander : ");
		lsbg     = new Label("Blood Group : ");
		lsmob    = new Label("Mobile : ");
		lsadrs   = new Label("Address : ");

		gander = new CheckboxGroup();  
        male   = new Checkbox("Male", gander, false);   
        female = new Checkbox("Female", gander, false);  

        trainpass = new Checkbox("Apply For Train Concession");

        csclass = new Choice();  
        csclass.add("BSc IT");  
        csclass.add("BSc CS");  
        csclass.add("BCA");  
        csclass.add("MSc IT");  
        csclass.add("MSc CS");
        csclass.add("MCA");

		tfsname   = new TextField();
		tfsrollno = new TextField();
		tfsmob    = new TextField();

		tasadrs = new TextArea("", 2 , 100 , TextArea.SCROLLBARS_NONE);

		submit  = new Button("Submit");

		display_details = new TextArea("", 2 , 100 , TextArea.SCROLLBARS_NONE);
		display_details.setEditable(false);

		lsname.setBounds(10, 30, 50, 20);
		tfsname.setBounds(70, 30, 150, 20);
		
		lsrollno.setBounds(240, 30, 50, 20);
		tfsrollno.setBounds(300, 30, 150, 20);
		
		lsclass.setBounds(10, 60, 50, 20);
		csclass.setBounds(70, 60, 150, 20);
		
		lgander.setBounds(240, 60, 50, 20);
		male.setBounds(300, 60, 50, 20);
		female.setBounds(360, 60, 50, 20);
		
		lsmob.setBounds(10, 90, 50, 20);
		tfsmob.setBounds(70, 90, 150, 20);

		trainpass.setBounds(240, 90, 150, 20);

		lsadrs.setBounds(10, 120, 50, 20);
		tasadrs.setBounds(70, 120, 380, 70);

		submit.setBounds(10, 200, 440, 30);

		display_details.setBounds(10, 240, 440, 130);

		add(lsname);
		add(lsrollno);
		add(lsclass);
		add(lgander);
		add(lsbg);
		add(lsadrs);
		add(lsmob);

		add(male);
		add(female);

		add(csclass);

		add(tfsname);
		add(tfsrollno);
		add(tasadrs);
		add(tfsmob);

		add(trainpass);

		add(submit);

		add(display_details);

		submit.addActionListener(this);

		setTitle("Students Details");
		setSize(460,390);
		setLayout(null);
		setVisible(true);

		addWindowListener(new WindowAdapter()
		{  
            public void windowClosing(WindowEvent e)
            {  
                dispose();  
            }  
        });
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==submit)
		{
			String tp = trainpass.getState() ? "Applied for Train Concession" : "Not Applied for Train Concession";

			String sdetails = " ***** Students Details *****\n Name : " + tfsname.getText() + "\n Roll No. :" + tfsrollno.getText() + "\n Class : " + csclass.getSelectedItem() + "\n Gander : " + gander.getSelectedCheckbox().getLabel() + "\n Mobile : " + tfsmob.getText() + "\n Train Pass : " + tp + "\n Address : " + tasadrs.getText();

			display_details.setText(sdetails);
		}
	}

	public static void main(String[] args)
	{
		new Student();
	}
}
