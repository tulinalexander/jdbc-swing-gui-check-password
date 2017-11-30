package com.alex.employeesearch.ui.employees;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.alex.employeesearch.core.Employee;
import com.alex.employeesearch.dao.EmployeeDAO;
import com.alex.employeesearch.ui.EmployeeSearchApp;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;

public class EmployeeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JTextField salaryTextField;
	private JTextField positionTextField;
	private JTextField departmentTextField;

	private EmployeeDAO employeeDAO;

	private EmployeeSearchApp employeeSearchApp;

	private Employee previousEmployee = null;
	private boolean updateMode = false;

	private int userId;
	
	public EmployeeDialog(EmployeeSearchApp theEmployeeSearchApp,
			EmployeeDAO theEmployeeDAO, Employee thePreviousEmployee, boolean theUpdateMode, int theUserId) {
		this();
		employeeDAO = theEmployeeDAO;
		employeeSearchApp = theEmployeeSearchApp;

		previousEmployee = thePreviousEmployee;
		
		updateMode = theUpdateMode;

		userId = theUserId;
		
		if (updateMode) {
			setTitle("Update Employee");
			
			populateGui(previousEmployee);
		}
	}

	private void populateGui(Employee theEmployee) {

		firstNameTextField.setText(theEmployee.getFirstName());
		lastNameTextField.setText(theEmployee.getLastName());
		emailTextField.setText(theEmployee.getEmail());
		salaryTextField.setText(theEmployee.getSalary().toString());
		departmentTextField.setText(theEmployee.getDepartment());
		positionTextField.setText(theEmployee.getPosition());
	}

	public EmployeeDialog(EmployeeSearchApp theEmployeeSearchApp,
			EmployeeDAO theEmployeeDAO, int theUserId) {
		this(theEmployeeSearchApp, theEmployeeDAO, null, false, theUserId);
	}

	/**
	 * Create the dialog.
	 */

	private void placeComponents(JPanel panel) {

		panel.setLayout(null);

		JLabel lbFirstName = new JLabel("First Name");
		lbFirstName.setBounds(10,20,80,25);
		panel.add(lbFirstName);

		firstNameTextField = new JTextField(20);
		firstNameTextField.setBounds(100,20,165,25);
		panel.add(firstNameTextField);

		// Same process for password label and text field.
		JLabel lbLastName = new JLabel("Last Name");
		lbLastName.setBounds(10,50,80,25);
		panel.add(lbLastName);

		lastNameTextField = new JTextField(20);
		lastNameTextField.setBounds(100,50,165,25);
		panel.add(lastNameTextField);

		// Same process for password label and text field.
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setBounds(10,80,80,25);
		panel.add(lbEmail);

		emailTextField = new JTextField(20);
		emailTextField.setBounds(100,80,165,25);
		panel.add(emailTextField);

		// Same process for password label and text field.
		JLabel lbSalary = new JLabel("Salary");
		lbSalary.setBounds(10,110,80,25);
		panel.add(lbSalary);

		salaryTextField = new JTextField(20);
		salaryTextField.setBounds(100,110,165,25);
		panel.add(salaryTextField);

		// Same process for password label and text field.
		JLabel lbDepartment = new JLabel("Department");
		lbDepartment.setBounds(10,140,80,25);
		panel.add(lbDepartment);

		departmentTextField = new JTextField(20);
		departmentTextField.setBounds(100,140,165,25);
		panel.add(departmentTextField);

		// Same process for password label and text field.
		JLabel lbPosition = new JLabel("Position");
		lbPosition.setBounds(10,170,80,25);
		panel.add(lbPosition);

		positionTextField = new JTextField(20);
		positionTextField.setBounds(100,170,165,25);
		panel.add(positionTextField);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(100,200,165,25);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						saveEmployee();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

//		// Creating login button
//		JButton loginButton = new JButton("login");
//		loginButton.setBounds(10, 80, 80, 25);
//		panel.add(loginButton);
	}

	public EmployeeDialog() {
		setTitle("Add Employee");
		setBounds(100, 100, 350, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		getContentPane().add(contentPanel, BorderLayout.CENTER);
//		{
//			JLabel lblFirstName = new JLabel("First Name");
//			contentPanel.add(lblFirstName);
//		}
//		{
//			firstNameTextField = new JTextField();
//			contentPanel.add(firstNameTextField, "4, 2, fill, default");
//			firstNameTextField.setColumns(10);
//		}
//		{
//			JLabel lblLastName = new JLabel("Last Name");
//			contentPanel.add(lblLastName);
//		}
//		{
//			lastNameTextField = new JTextField();
//			contentPanel.add(lastNameTextField, "4, 4, fill, default");
//			lastNameTextField.setColumns(10);
//		}
//		{
//			JLabel lblNewLabel = new JLabel("Email");
//			contentPanel.add(lblNewLabel, "2, 6, right, default");
//		}
//		{
//			emailTextField = new JTextField();
//			contentPanel.add(emailTextField, "4, 6, fill, default");
//			emailTextField.setColumns(10);
//		}
//		{
//			JLabel lblSalary = new JLabel("Salary");
//			contentPanel.add(lblSalary, "2, 8, right, default");
//		}
//		{
//			salaryTextField = new JTextField();
//			contentPanel.add(salaryTextField, "2, 10, fill, default");
//			salaryTextField.setColumns(10);
//		}
//		{
//			JLabel lblDepartment = new JLabel("Department");
//			contentPanel.add(lblDepartment, "2, 8, right, default");
//		}
//		{
//			departmentTextField = new JTextField();
//			contentPanel.add(departmentTextField, "2, 10, fill, default");
//			departmentTextField.setColumns(10);
//		}
//
//		{
//			JLabel position = new JLabel("Position");
//			contentPanel.add(position, "4,10 , right, default");
//		}
//		{
//			positionTextField = new JTextField();
//			contentPanel.add(positionTextField);
//			positionTextField.setColumns(10);
//		}
//
//		{
//			JPanel buttonPane = new JPanel();
//			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
//			getContentPane().add(buttonPane, BorderLayout.SOUTH);
//			{
//				JButton okButton = new JButton("Save");
//				okButton.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						saveEmployee();
//					}
//				});
//				okButton.setActionCommand("OK");
//				buttonPane.add(okButton);
//				getRootPane().setDefaultButton(okButton);
//			}
//			{
//				JButton cancelButton = new JButton("Cancel");
//				cancelButton.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						setVisible(false);
//					}
//				});
//				cancelButton.setActionCommand("Cancel");
//				buttonPane.add(cancelButton);
//			}
//		}
		placeComponents(contentPanel);
	}

	protected BigDecimal convertStringToBigDecimal(String salaryStr) {

		BigDecimal result = null;

		try {
			double salaryDouble = Double.parseDouble(salaryStr);

			result = BigDecimal.valueOf(salaryDouble);
		} catch (Exception exc) {
			System.out.println("Invalid value. Defaulting to 0.0");
			result = BigDecimal.valueOf(0.0);
		}

		return result;
	}

	protected void saveEmployee() {

		// get the employee info from gui
		String firstName = firstNameTextField.getText();
		String lastName = lastNameTextField.getText();
		String email = emailTextField.getText();

		String salaryStr = salaryTextField.getText();
		BigDecimal salary = convertStringToBigDecimal(salaryStr);
		String department = departmentTextField.getText();
		String position = positionTextField.getText();

		Employee tempEmployee = null;

		if (updateMode) {
			tempEmployee = previousEmployee;
			
			tempEmployee.setLastName(lastName);
			tempEmployee.setFirstName(firstName);
			tempEmployee.setEmail(email);
			tempEmployee.setSalary(salary);
			
		} else {
			tempEmployee = new Employee(lastName, firstName, email, salary,department,position);
		}

		try {
			// save to the database
			if (updateMode) {
				employeeDAO.updateEmployee(tempEmployee, userId);
			} else {
				employeeDAO.addEmployee(tempEmployee, userId);
			}

			// close dialog
			setVisible(false);

			// refresh gui list
			employeeSearchApp.refreshEmployeesView();

			// show success message
			JOptionPane.showMessageDialog(employeeSearchApp,
					"Employee saved succesfully.", "Employee Saved",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(employeeSearchApp,
					"Error saving employee: " + exc.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}
