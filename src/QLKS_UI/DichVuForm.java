package QLKS_UI;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import QLKS_OBJECT.DichVu;

import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import com.mysql.jdbc.Driver;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class DichVuForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaDV;
	private JTextField txtTenDV;
	private JTextField txtGiaDV;
	//private JTable table;
	
	DefaultTableModel model;
	JTable table; 
	
	public static Connection con= null;
    public static Statement st= null; 
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DichVuForm frame = new DichVuForm();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

    public static void ketNoiCSDLMySql() {
		// TODO Auto-generated method stub
		try
		{
			String strlConn = "jdbc:mysql://localhost/ql_khachsan";
			Properties pro = new Properties();
			pro.put("user", "root");
			pro.put("password", "");
			Driver driver = new Driver();
			con = driver.connect(strlConn, pro);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
   	
	public void hienThiDanhSachDichVu()
	{
        try
		{
			String sql ="select * from dichvu";
			st = con.createStatement();
			ResultSet result = st.executeQuery(sql);
			model = new DefaultTableModel();
			model.addColumn("Mã dịch vụ");
			model.addColumn("Tên dịch vụ");
			model.addColumn("Giá dịch vụ");
			while (result.next())
			{
				Vector<Object> vec = new Vector<Object>();
				vec.add(result.getString(1));
				vec.add(result.getString(2));
				vec.add(result.getDouble(3));
				model.addRow(vec);
			}
		}
		catch (Exception ex)
		{
			
		}
	}
	
	
	/**
	 * Create the frame.
	 */
	
	
	
	public DichVuForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DichVuForm.class.getResource("/QLKS_IMAGE/hotel.png")));
		ketNoiCSDLMySql();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH DỊCH VỤ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(30, 144, 255)));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 43, 442, 341);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		txtMaDV = new JTextField();
		txtMaDV.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMaDV.setColumns(10);
		txtMaDV.setBounds(131, 20, 169, 24);
		panel_2.add(txtMaDV);
		
		JLabel lblNewLabel_1 = new JLabel("Mã dịch vụ");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 20, 111, 24);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên dịch vụ");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 73, 111, 24);
		panel_2.add(lblNewLabel_1_1);
		
		txtTenDV = new JTextField();
		txtTenDV.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTenDV.setColumns(10);
		txtTenDV.setBounds(131, 73, 169, 24);
		panel_2.add(txtTenDV);
		
		JLabel lblNewLabel_1_2 = new JLabel("Giá dịch vụ");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(10, 127, 111, 24);
		panel_2.add(lblNewLabel_1_2);
		
		txtGiaDV = new JTextField();
		txtGiaDV.setFont(new Font("Arial", Font.PLAIN, 17));
		txtGiaDV.setColumns(10);
		txtGiaDV.setBounds(131, 127, 169, 24);
		panel_2.add(txtGiaDV);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Connection con = getConnection();
		        try {
		            // Tạo một đối tượng để thực hiện công việc
		            st = (Statement) con.createStatement();
		            String query = "INSERT INTO DichVu(MADV,TENDV, GIADV) VALUES('" + txtMaDV.getText() + "',"
		            + "'" + txtTenDV.getText() + "','" + txtGiaDV.getText() + "')";

		            st.execute(query);
		            hienThiDanhSachDichVu();

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		        table.setModel(model);
			}
		});
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThem.setBackground(new Color(30, 144, 255));
		btnThem.setBounds(10, 178, 111, 33);
		panel_2.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow()==-1) {
		            if (table.getRowCount()==0) {
		                // lblError.setText("Table is empty");
		            }
		            else{
		                //  lblError.setText("You must select a Tennis Player");
		            }
		        }
		        else{
		            model = (DefaultTableModel) table.getModel();
		            
		            try {
		            	String code = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
			            // Tạo một đối tượng để thực hiện công việc
			            st = (Statement) con.createStatement();
			            String query = "DELETE FROM dichvu WHERE MADV = '" + code + "'";
			            st.executeUpdate(query);

			        } catch (Exception ex) {

			            ex.printStackTrace();
			        }
		            
		            try {
			            // Tạo một đối tượng để thực hiện công việc
			            st = (Statement) con.createStatement();
			            String query = "INSERT INTO DichVu(MADV,TENDV, GIADV) VALUES('" + txtMaDV.getText() + "',"
			            + "'" + txtTenDV.getText() + "','" + txtGiaDV.getText() + "')";

			            st.execute(query);
			            hienThiDanhSachDichVu();

			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
		            table.setModel(model);
		        }
			}
		});
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Arial", Font.PLAIN, 17));
		btnSua.setBackground(new Color(30, 144, 255));
		btnSua.setBounds(143, 178, 111, 33);
		panel_2.add(btnSua);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTenDV.setText("");
				txtMaDV.setText("");
				txtGiaDV.setText("");
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Arial", Font.PLAIN, 17));
		btnClear.setBackground(new Color(30, 144, 255));
		btnClear.setBounds(279, 178, 111, 33);
		panel_2.add(btnClear);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        try {
		            // Tạo một đối tượng để thực hiện công việc
		            st = (Statement) con.createStatement();
		            String query = "DELETE FROM dichvu WHERE MADV = '" + txtMaDV.getText() + "'";
		            st.executeUpdate(query);
		            hienThiDanhSachDichVu();

		        } catch (Exception ex) {

		            ex.printStackTrace();
		        }
		        table.setModel(model);
			}
		});
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Arial", Font.PLAIN, 17));
		btnXoa.setBackground(new Color(30, 144, 255));
		btnXoa.setBounds(10, 239, 111, 33);
		panel_2.add(btnXoa);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DichVuForm.this.dispose();
			}
		});
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThoat.setBackground(new Color(30, 144, 255));
		btnThoat.setBounds(143, 239, 111, 33);
		panel_2.add(btnThoat);
		
		
		JPanel pnTable = new JPanel();
		pnTable.setBackground(Color.LIGHT_GRAY);
		pnTable.setBounds(489, 43, 442, 341);
		panel_1.add(pnTable);
		

		pnTable.setLayout(new BorderLayout(0, 0));
		hienThiDanhSachDichVu();
		table = new JTable(model);
		table.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JScrollPane scTable = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		pnTable.add(scTable, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Thông tin dịch vụ");
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 30, 138, 13);
		panel_1.add(lblNewLabel_2);
	}
}
