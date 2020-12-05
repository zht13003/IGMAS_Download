package zhou;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class GUI {
	static JList<String> list;
	static String saveDir = "C:\\Users";
	static String selectFile = "All_All";
	static JPanel cards = new JPanel(new CardLayout());
	static CardLayout c1;
	static JComboBox select1 = new JComboBox();
	static JComboBox select2 = new JComboBox();
	
	private static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		JFrame frame = new JFrame("iGMAS-Download");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		JMenu menu1 = new JMenu("文件");
		JMenuItem item = new JMenuItem("选择保存路径");
		item.addActionListener(new GUI().new MyActionListener());
		menu1.add(item);
		JMenuBar bar = new JMenuBar();
		bar.add(menu1);
		bar.setVisible(true);
		frame.setJMenuBar(bar);
		
		JMenu menu2 = new JMenu("精密星历钟差");
		JMenu menu3 = new JMenu("测站坐标参数");
		JMenu menu4 = new JMenu("大气环境参数");
		JMenu menu5 = new JMenu("频间偏差");
		JMenu menu6 = new JMenu("完好性产品");
		bar.add(menu2);
		bar.add(menu3);
		bar.add(menu4);
		bar.add(menu5);
		bar.add(menu6);
		
		JPanel jp1 = new JPanel();
		JPanel jp_NORTH = new JPanel();
		JPanel jp1_1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp2_1 = new JPanel();
		JPanel jp2_1_1 = new JPanel();
		JPanel jp2_1_2 = new JPanel();
		JPanel jp2_1_2_1 = new JPanel();
		JPanel jp2_1_2_2 = new JPanel();
		JPanel jp2_1_3 = new JPanel();
		JPanel jp2_1_3_1 = new JPanel();
		JPanel jp2_1_3_2 = new JPanel();
		JPanel jp2_1_3_1_1 = new JPanel();
		JPanel jp2_1_3_2_1 = new JPanel();
		JPanel jp2_1_3_1_1_1 = new JPanel();
		JPanel jp2_1_3_1_1_2 = new JPanel();
		JPanel jp2_1_3_1_2_1 = new JPanel();
		JPanel jp2_1_3_1_2_2 = new JPanel();
		JPanel jp3 = new JPanel();
		
		jp1.setLayout(new BorderLayout());
		jp1_1.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
		jp_NORTH.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
		jp2.setLayout(new BorderLayout());
		jp2_1.setLayout(new BorderLayout());
		jp2_1_1.setLayout(new BorderLayout());
		jp2_1_2.setLayout(new BorderLayout());
		jp2_1_2_1.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
		jp2_1_2_2.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
		jp2_1_3.setLayout(new GridLayout(2,2,20,2));
		jp2_1_3_1.setLayout(new BorderLayout());
		jp2_1_3_2.setLayout(new BorderLayout());
		jp2_1_3_2_1.setLayout(new BorderLayout());
		jp2_1_3_1_1.setLayout(new BorderLayout());
		jp2_1_3_1_1_1.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
		jp2_1_3_1_1_2.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
		jp2_1_3_1_2_1.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
		jp2_1_3_1_2_2.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
		
		JLabel label1 = new JLabel(" IGMAS Data Acquisition             ");
		label1.setFont(new Font("简体", Font.BOLD,14));
		JLabel label2 = new JLabel("Real-time:");
		
		JLabel l2_0 = new JLabel("Post:");
		JLabel l2_1 = new JLabel("  Start:");
		JLabel l2_2 = new JLabel("  End: ");
		
		JLabel l2_3_1 = new JLabel("UserName");
		JLabel l2_3_2 = new JLabel("Password");
		
		jp_NORTH.add(label1);

		jp2_1_2.add(l2_0, BorderLayout.NORTH);
		jp2_1_3.add(l2_3_1);
		jp2_1_3.add(l2_3_2);
		
		jp2_1_3_1.add(l2_1, BorderLayout.WEST);
		jp2_1_3_2.add(l2_2, BorderLayout.WEST);
		
		jp2_1_3_1.add(jp2_1_3_1_1, BorderLayout.CENTER);
		jp2_1_3_2.add(jp2_1_3_2_1, BorderLayout.CENTER);
		
		jp2_1_3_1_1.add(jp2_1_3_1_1_1, BorderLayout.NORTH);
		jp2_1_3_1_1.add(jp2_1_3_1_1_2, BorderLayout.SOUTH);
		jp2_1_3_2_1.add(jp2_1_3_1_2_1, BorderLayout.NORTH);
		jp2_1_3_2_1.add(jp2_1_3_1_2_2, BorderLayout.SOUTH);
		
		jp2_1_2.add(jp2_1_3_1, BorderLayout.CENTER);
		jp2_1_2.add(jp2_1_3_2, BorderLayout.SOUTH);
		
		JTextField t1 = new JTextField(10);
		JPasswordField t2 = new JPasswordField();

		jp2_1_3.add(t1);
		jp2_1_3.add(t2);
		
//		JLabel l1_N = new JLabel("Download Mode��");
//		JRadioButton rb1 = new JRadioButton("Real-time", true);
//		JRadioButton rb2 = new JRadioButton("Period of time");
//		ButtonGroup group = new ButtonGroup();
//		group.add(rb1);
//		group.add(rb2);
//		jp_NORTH.add(l1_N);
//		jp_NORTH.add(rb1);
//		jp_NORTH.add(rb2);
		
		JButton b2 = new JButton("Download");
		b2.setPreferredSize(new Dimension(50,25));
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Download.downloadRealTime(saveDir);
			}
		});
		
		jp2_1_1.add(b2);
		JPanel take1 = new JPanel();
		JPanel take2 = new JPanel();
		jp2_1_1.add(take1, BorderLayout.EAST);
		jp2_1_1.add(take2, BorderLayout.WEST);
		
		JComboBox<Integer> year1 = new JComboBox<Integer>();
		JComboBox<Integer> month1 = new JComboBox<Integer>();
		JComboBox<Integer> day1 = new JComboBox<Integer>();
		JComboBox<Integer> hour1 = new JComboBox<Integer>();
		JComboBox<Integer> minute1 = new JComboBox<Integer>();
		JComboBox<Integer> second1 = new JComboBox<Integer>();
		JComboBox<Integer> year2 = new JComboBox<Integer>();
		JComboBox<Integer> month2 = new JComboBox<Integer>();
		JComboBox<Integer> day2 = new JComboBox<Integer>();
		JComboBox<Integer> hour2 = new JComboBox<Integer>();
		JComboBox<Integer> minute2 = new JComboBox<Integer>();
		JComboBox<Integer> second2 = new JComboBox<Integer>();
		for(int i = 2000;i < 2021;i++) {
			year1.addItem(i);
			year2.addItem(i);
		}
		for(int i = 1;i < 13;i++) {
			month1.addItem(i);
			month2.addItem(i);
		}
		for(int i = 1;i < 32;i++) {
			day1.addItem(i);
			day2.addItem(i);
		}
		for(int i = 0;i < 24;i++) {
			hour1.addItem(i);
			hour2.addItem(i);
		}
		for(int i = 0;i < 60;i++) {
			minute1.addItem(i);
			minute2.addItem(i);
			second1.addItem(i);
			second2.addItem(i);
		}
		hour1.setPreferredSize(new Dimension(55,27));
		minute1.setPreferredSize(new Dimension(55,27));
		second1.setPreferredSize(new Dimension(55,27));
		hour2.setPreferredSize(new Dimension(55,27));
		minute2.setPreferredSize(new Dimension(55,27));
		second2.setPreferredSize(new Dimension(55,27));
		
		year1.setPreferredSize(new Dimension(55,27));
		month1.setPreferredSize(new Dimension(55,27));
		day1.setPreferredSize(new Dimension(55,27));
		year2.setPreferredSize(new Dimension(55,27));
		month2.setPreferredSize(new Dimension(55,27));
		day2.setPreferredSize(new Dimension(55,27));
		
		jp2_1_3_1_1_1.add(year1);
		jp2_1_3_1_1_1.add(month1);
		jp2_1_3_1_1_1.add(day1);
		jp2_1_3_1_1_2.add(hour1);
		jp2_1_3_1_1_2.add(minute1);
		jp2_1_3_1_1_2.add(second1);
		
		jp2_1_3_1_2_1.add(year2);
		jp2_1_3_1_2_1.add(month2);
		jp2_1_3_1_2_1.add(day2);
		jp2_1_3_1_2_2.add(hour2);
		jp2_1_3_1_2_2.add(minute2);
		jp2_1_3_1_2_2.add(second2);
		
		
		jp2_1.add(jp2_1_1, BorderLayout.NORTH);
		jp2_1.add(jp2_1_2, BorderLayout.CENTER);
		jp2_1.add(jp2_1_3, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		
		String[] items = new String[] {"ISU_CLK", "ISR_CLK", "ISC_CLK",
				"ISU_ERP", "ISR_ERP", "ISC_ERP","ISC7_ERP",
				"ISC_SNX", "ISC7_SNX",
				"ISU_SP3", "ISR_SP3","ISC_SP3",
				"ISU_SUM", "ISR_SUM", "ISC7_SUM",
				"ISU_TRO", "ISC_TRO"};
		list = new JList<String>();
		list.setListData(items);
		scrollPane.setViewportView(list);
		
		
		select1.addItem("All");
		select1.addItem("钟差产品");
		select1.addItem("地球自转参数产品");
		select1.addItem("跟踪站地心坐标产品");
		select1.addItem("轨道产品");
		select1.addItem("总结信息产品");
		select1.addItem("对流层产品");
		select2.addItem("All");
		select2.addItem("超快速");
		select2.addItem("快速");
		select2.addItem("最终");
		jp1_1.add(select1);
		jp1_1.add(select2);
		select1.addActionListener(e -> {
			// TODO Auto-generated method stub
			do_select_changed(e);
		});

		String[] items1 = new String[] {items[0], items[1], items[2]};
		String[] items2 = new String[] {items[3], items[4], items[5], items[6]};
		String[] items3 = new String[] {items[7], items[8]};
		String[] items4 = new String[] {items[9], items[10], items[11]};
		String[] items5 = new String[] {items[12], items[13], items[14]};
		String[] items6 = new String[] {items[15], items[16]};
		JList<String> list1 = new JList<String>();
		JList<String> list2 = new JList<String>();
		JList<String> list3 = new JList<String>();
		JList<String> list4 = new JList<String>();
		JList<String> list5 = new JList<String>();
		JList<String> list6 = new JList<String>();
		list1.setListData(items1);
		list2.setListData(items2);
		list3.setListData(items3);
		list4.setListData(items4);
		list5.setListData(items5);
		list6.setListData(items6);
		JPanel jp1_1_1 = new JPanel();
		JPanel jp1_1_2 = new JPanel();
		JPanel jp1_1_3 = new JPanel();
		JPanel jp1_1_4 = new JPanel();
		JPanel jp1_1_5 = new JPanel();
		JPanel jp1_1_6 = new JPanel();
		JScrollPane scrollPanes1 = new JScrollPane();
		JScrollPane scrollPanes2 = new JScrollPane();
		JScrollPane scrollPanes3 = new JScrollPane();
		JScrollPane scrollPanes4 = new JScrollPane();
		JScrollPane scrollPanes5 = new JScrollPane();
		JScrollPane scrollPanes6 = new JScrollPane();
		scrollPanes1.setViewportView(list1);
		scrollPanes2.setViewportView(list2);
		scrollPanes3.setViewportView(list3);
		scrollPanes4.setViewportView(list4);
		scrollPanes5.setViewportView(list5);
		scrollPanes6.setViewportView(list6);
		cards.add(scrollPane, "All_All");
		cards.add(scrollPanes1, "钟差产品_All");
		cards.add(scrollPanes2, "地球自转参数产品_All");
		cards.add(scrollPanes3, "跟踪站地心坐标_All");
		cards.add(scrollPanes4, "轨道产品_All");
		cards.add(scrollPanes5, "总结信息产品_All");
		cards.add(scrollPanes6, "对流层产品_All");
		c1 = (CardLayout)(cards.getLayout());
		c1.show(cards, "All_All");
		
		
		JButton b1 = new JButton("Download");
		b1.setPreferredSize(new Dimension(50,25));
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Integer> timeDate1 = new ArrayList<>();
				List<Integer> timeDate2 = new ArrayList<>();
				timeDate1.add((Integer) year1.getSelectedItem());
				timeDate1.add((Integer) month1.getSelectedItem());
				timeDate1.add((Integer) day1.getSelectedItem());
				timeDate1.add((Integer) hour1.getSelectedItem());
				timeDate1.add((Integer) minute1.getSelectedItem());
				timeDate1.add((Integer) second1.getSelectedItem());
				timeDate2.add((Integer) year2.getSelectedItem());
				timeDate2.add((Integer) month2.getSelectedItem());
				timeDate2.add((Integer) day2.getSelectedItem());
				timeDate2.add((Integer) hour2.getSelectedItem());
				timeDate2.add((Integer) minute2.getSelectedItem());
				timeDate2.add((Integer) second2.getSelectedItem());
				
//				List<Integer> temp2 = new ArrayList<>();
//				List<Integer> temp1 = new ArrayList<>();
//				temp1.add(2020);
//				temp1.add(3);
//				temp1.add(18);
//				temp1.add(15);
//				temp1.add(1);
//				temp1.add(1);
//				temp2.add(2020);
//				temp2.add(3);
//				temp2.add(20);
//				temp2.add(15);
//				temp2.add(50);
//				temp2.add(1);
				switch(selectFile) {
				case "All_All":
					Download.downloadList(list.getSelectedValuesList(), timeDate1, timeDate2, saveDir);break;
				case "钟差产品_All":
					Download.downloadList(list1.getSelectedValuesList(), timeDate1, timeDate2, saveDir);break;
				case "地球自转参数产品_All":
					Download.downloadList(list2.getSelectedValuesList(), timeDate1, timeDate2, saveDir);break;
				case "跟踪站地心坐标_All":
					Download.downloadList(list3.getSelectedValuesList(), timeDate1, timeDate2, saveDir);break;
				case "轨道产品_All":
					Download.downloadList(list4.getSelectedValuesList(), timeDate1, timeDate2, saveDir);break;
				case "总结信息产品_All":
					Download.downloadList(list5.getSelectedValuesList(), timeDate1, timeDate2, saveDir);break;
				case "对流层产品_All":
					Download.downloadList(list6.getSelectedValuesList(), timeDate1, timeDate2, saveDir);break;
				}
			}
		});
		
		jp1.add(cards, BorderLayout.CENTER);
		jp1.add(jp1_1, BorderLayout.NORTH);
		jp2.add(b1, BorderLayout.SOUTH);
		jp2.add(label2, BorderLayout.NORTH);
		jp2.add(jp2_1, BorderLayout.CENTER);
		
		frame.add(jp_NORTH, BorderLayout.NORTH);
		frame.add(jp1, BorderLayout.WEST);
		frame.add(jp2, BorderLayout.CENTER);
		
		frame.setBounds(400,400,400,400);
		frame.setSize(1000, 600);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
	}
	
	protected static void do_select_changed(ActionEvent e) {
		selectFile = select1.getSelectedItem().toString() + "_" + select2.getSelectedItem().toString();
		c1.show(cards, selectFile);
	}
	
	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg) {
			JFileChooser fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int val = fc.showSaveDialog(null);
			saveDir = fc.getSelectedFile().toString();
			System.out.println(saveDir);
		}
	}
	
}
