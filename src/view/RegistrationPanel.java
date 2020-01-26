package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import valueObject.VCLecture;

public class RegistrationPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private ActionListener actionHandler;

	private SelectionPanel selectionPanel;
	private MovePanel movePanel1;
	private BasketPanel basketPanel;
	private MovePanel movePanel2;
	private BasketPanel resultPanel;

	private String id;

	public RegistrationPanel() {
		// attributes
		this.setLayout(new BorderLayout());
		this.setBackground(Color.white);

		// component
		this.setLayout(new BorderLayout());

		JPanel forLayoutPane = new JPanel();
		forLayoutPane.setBackground(Color.white);
		forLayoutPane.setLayout(new GridLayout(1, 3));

		this.selectionPanel = new SelectionPanel();
		forLayoutPane.add(this.selectionPanel);

		JPanel BMPanel = new JPanel();
		BMPanel.setBackground(Color.white);

		BMPanel.setLayout(new BoxLayout(BMPanel, BoxLayout.X_AXIS));
		ActionListener actionHandler = new ActionHandler();

		this.movePanel1 = new MovePanel(actionHandler);
		BMPanel.add(this.movePanel1);

		this.basketPanel = new BasketPanel();
		BMPanel.add(this.basketPanel);
		
		forLayoutPane.add(BMPanel);


		JPanel RMPanel = new JPanel();
		RMPanel.setBackground(Color.white);
		RMPanel.setLayout(new BoxLayout(RMPanel, BoxLayout.X_AXIS));

		this.movePanel2 = new MovePanel(actionHandler);
		RMPanel.add(this.movePanel2);

		this.resultPanel = new BasketPanel();
		RMPanel.add(this.resultPanel);

		forLayoutPane.add(RMPanel);

		
		JPanel westPane=new JPanel();
		westPane.setBackground(Color.white);
		JPanel eastPane=new JPanel();
		eastPane.setBackground(Color.white);
		JPanel southPane=new JPanel();
		southPane.setBackground(Color.white);
		JPanel northPane=new JPanel();
		northPane.setBackground(Color.white);

		this.add(northPane, BorderLayout.NORTH);
		this.add(southPane, BorderLayout.SOUTH);
		this.add(westPane, BorderLayout.WEST);
		this.add(eastPane, BorderLayout.EAST);
		this.add(forLayoutPane, BorderLayout.CENTER);

	}

	public void initialize(String id) {
		this.selectionPanel.initialize(id);
		this.basketPanel.initialize(id+"Basket");
		this.resultPanel.initialize(id+"Result");
		this.id = id;
	}

	public void initialize() {
		this.selectionPanel.initialize(this.id);
		this.basketPanel.initialize(id+"Basket");
		this.resultPanel.initialize(id+"Result");
	}
	public void finish(String id) {
		this.selectionPanel.finish(id);
		this.basketPanel.finish(id+"Basket");
		this.resultPanel.finish(id+"Result");

	}

	private void moveLecturesToBasket() { // 렉쳐리스트 -> 배스킷
		// get Data
		Vector<VCLecture> selectedLectures = this.selectionPanel.getSelectedLectures();
		// add Data
		this.basketPanel.addRows(selectedLectures);
	}

	private void removeLectureFromBasket() { // 배스킷 -> x
		// get Data
		Vector<VCLecture> selectedLectures = this.basketPanel.getSelectedLectures();
		// remove Data
		this.basketPanel.removeSelectedRows();
	}

	private void moveLecturesToResult() { // 배스킷 -> 리저트
		// get Data
		Vector<VCLecture> selectedLectures = this.basketPanel.getSelectedLectures();
		// remove Data
		this.basketPanel.removeSelectedRows();
		// add Data
		this.resultPanel.addRows(selectedLectures);

	}

	private void moveLecturesFromResultToBasket() { // 리저트->배스킷
		// get Data
		Vector<VCLecture> selectedLectures = this.resultPanel.getSelectedLectures();
		// remove Data
		this.resultPanel.removeSelectedRows();
		// add Data1
		this.basketPanel.addRows(selectedLectures);

	}
	
	
	


	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(movePanel1.getLeftButton())) {
				removeLectureFromBasket();
			} else if (e.getSource().equals(movePanel1.getRightButton())) {
				moveLecturesToBasket();
			} else if (e.getSource().equals(movePanel2.getLeftButton())) {
				moveLecturesFromResultToBasket();
			} else if (e.getSource().equals(movePanel2.getRightButton())) {
				moveLecturesToResult();
			}

		}

	}

}
