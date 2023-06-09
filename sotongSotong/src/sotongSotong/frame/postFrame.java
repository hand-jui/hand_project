package sotongSotong.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import sotongSotong.controller.Controller;
import sotongSotong.dto.DTO;

public class postFrame extends JFrame {

	JPanel jpanel;

	JButton postB;

	JLabel title;
	JLabel nickname;
	JLabel password;

	JTextArea tArea;
	JTextField titleText;
	JTextField nickText;
	JTextField pwText;

	public postFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	public postFrame(int no, String title, String content) {
		initData();
		setInitLayout();
		addEventListener();

	}

	private void initData() {
		setTitle("글 쓰기");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jpanel = new JPanel();
		jpanel.setSize(600, 600);
		jpanel.setLocation(0, 0);

		title = new JLabel("제목 | ");
		title.setSize(50, 30);
		title.setLocation(35, 40);

		nickname = new JLabel("닉네임 | ");
		nickname.setSize(50, 30);
		nickname.setLocation(35, 500);

		password = new JLabel("비밀번호 | ");
		password.setSize(70, 30);
		password.setLocation(300, 500);

		titleText = new JTextField();
		titleText.setSize(400, 30);
		titleText.setLocation(80, 40);

		tArea = new JTextArea();
		tArea.setSize(500, 380);
		tArea.setLocation(50, 100);

		nickText = new JTextField();
		nickText.setSize(180, 30);
		nickText.setLocation(90, 500);

		pwText = new JTextField();
		pwText.setSize(180, 30);
		pwText.setLocation(380, 500);

		postB = new JButton("게시");
		postB.setSize(60, 30);
		postB.setLocation(500, 40);

	}

	private void setInitLayout() {
		this.setLayout(null);
		jpanel.setLayout(null);
		jpanel.add(title);
		jpanel.add(titleText);
		jpanel.add(tArea);
		jpanel.add(nickname);
		jpanel.add(nickText);
		jpanel.add(password);
		jpanel.add(pwText);
		jpanel.add(postB);
		add(jpanel);
		setResizable(false);
		setContentPane(jpanel);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void addEventListener() {

		postB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				DTO dto = new DTO();
				dto.setTitle(titleText.getText());
				dto.setContent(tArea.getText());
				dto.setNickname(nickText.getText());
				dto.setPassword(pwText.getText());

				Controller controller = new Controller();
				controller.post(dto.getTitle(), dto.getContent(), dto.getNickname(), dto.getPassword());

				new BoardFrame();
				dispose();
			}
		});
	}
//	titleText.setText(title);
//	tArea.setText(content);

	public JTextArea gettArea() {
		return tArea;
	}

	public void settArea(JTextArea tArea) {
		this.tArea = tArea;
	}

	public JTextField getTitleText() {
		return titleText;
	}

	public void setTitleText(JTextField titleText) {
		this.titleText = titleText;
	}

	public JTextField getNickText() {
		return nickText;
	}

	public void setNickText(JTextField nickText) {
		this.nickText = nickText;
	}

	public JTextField getPwText() {
		return pwText;
	}

	public void setPwText(JTextField pwText) {
		this.pwText = pwText;
	}

}
