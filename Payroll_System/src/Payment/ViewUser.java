package Payment;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import static Payment.ViewUser.setJTableColumnsWidth;

/**
 * This Swing program demonstrates how to set column with and row height
 * for a JTable component.
 * @author www.codejava.net
 *
 */
public class ViewUser extends JFrame {
	private JTable table = new JTable();
	
	public ViewUser() {
		super("View Users In Employee Payroll System");
		
		String columnNames[] = {"EmployeeID", "Name", "Department", "Annual Salary"};
		String[][] data = {
				{"1", "John", "Account", "3500000"},
				{"2", "Jane", "Audit", "3500000"},
				{"3", "Peter", "ICT", "3500000"},
				{"4", "Mary", "Human Resources", "3500000"},
				{"5", "Kim", "Human Resources", "3500000"},
				{"6", "Geogre", "Account", "3500000"},
				{"7", "Dash", "Domestic", "3500000"},
				{"8", "Tim", "Client Service", "3500000"},
				{"9", "Ana", "Admin", "3500000"},
				{"10", "Tom", "Audit", "3500000"},
				{"11", "Sam", "Communication", "3500000"},
				{"12", "Patrick", "ICT", "3500000"},
				{"13", "Jeremy", "ICT", "3500000"},
				{"14", "David", "Human Resources", "3500000"},
				{"15", "Steve", "Human Resources", "3500000"},
		};
		
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table.setModel(model);
		
		// sets row height		
		table.setRowHeight(60);
		//table.setRowHeight(3, 60);

		
		// sets column width
		TableColumnModel columnModel = table.getColumnModel();
		
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(150);
		columnModel.getColumn(2).setPreferredWidth(100);
		columnModel.getColumn(3).setPreferredWidth(180);
		
		
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(480, 300));
		
		add(scrollpane, BorderLayout.CENTER);		
		
		// using utility method
		setJTableColumnsWidth(table, 480, 10, 30, 30, 30);
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);		
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ViewUser().setVisible(true);
			}
		});
	}
	
    public static void setJTableColumnsWidth(JTable table, int tablePreferredWidth, 
    		double... percentages) {
        double total = 0;
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            total += percentages[i];
        }
        
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth((int)
                    (tablePreferredWidth * (percentages[i] / total)));
        }
    }	
}
