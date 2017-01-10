#include "mainwindow.h"
#include "highscores.h"
#include <iostream>


bool buttonPressed = true;
int buttonPressedCounter = 0;

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
	ui->testOutput->setText("How many times do you think you can press the button?");
	file.open("HighScores.dat");
	if (file.good()) {
		int limit = 0;
		std::string line = "";
		while (getline(file, line) && limit < 10)
		{
			std::string arr[2];
			int i = 0;
			std::stringstream ssin(line);
			while (ssin.good() && i < 2)
			{
				ssin >> arr[i];
				i++;
			}
			Score score;
			score.name = QString::fromStdString(arr[0]);
			score.score = std::stoi(arr[1]);
			scores.push_back(score);
			limit++;
		}
		file.close();
	}
	else {
		std::ofstream f("HighScores.dat");
		f << "Shelly\t35";
		f.close();
		Score s;
		s.name = "Shelly";
		s.score = 35;
		scores.push_back(s);
	}
}

MainWindow::~MainWindow()
{
    delete ui;
}

/*
 * play the game
 */
void MainWindow::on_testButton_clicked()
{
	if(buttonPressedCounter>=25)
	{
		ui->testOutput->setText("SILENCE, INFIDEL!!");
		ui->testButton->setEnabled(false);
	}
	else if(buttonPressedCounter>=20)
	{
		ui->testOutput->setText("Please stop...");
		buttonPressedCounter++;
	}
	else if(buttonPressedCounter>=15)
	{
		ui->testOutput->setText("Stop pressing the button...");
		buttonPressedCounter++;
	}
	else {
		QString text = "You pressed the button " + QString::number(buttonPressedCounter) + " times!";
		ui->testOutput->setText(text);
		buttonPressedCounter++;
	}
}

/*
 * give up and tally score
 */
void MainWindow::on_giveUpButton_clicked()
{
	bool ok;
	QString text = QInputDialog::getText(this, tr("QInputDialog::getText()"),
		tr("User name:"), QLineEdit::Normal,
		"enter your name", &ok);
	if (ok && !text.isEmpty() && text.length() <= 12)
	{
		Score score;
		if(text.contains(" "))
		{
			text.replace(" ", "_");
		}
		score.name = text;
		score.score = buttonPressedCounter;
		scores.push_back(score);
		buttonPressedCounter = 0;
		QString text = "You pressed the button " + QString::number(buttonPressedCounter) + " times!";
		ui->testOutput->setText(text);
		sortScores();

		std::ofstream f("HighScores.dat");
		for (int i = 0; i < scores.size(); i++)
		{
			f << scores[i].name.toStdString() << "\t" << scores[i].score << std::endl;
		}
		f.close();
	}
}



void MainWindow::on_actionHigh_Scores_triggered()
{
	HighScores h(NULL, &scores);
	h.exec();
}


void MainWindow::sortScores()
{
	bool done = false;
	while(!done && scores.size() > 1)
	{
		int i = 0;
		for(; i < scores.size()-1; i++)
		{
			Score a = scores[i];
			Score b = scores[i + 1];
			if(a.score<b.score)
			{
				scores[i] = b;
				scores[i + 1] = a;
				i = scores.size();
			}
		}
		i++;
		if (i == scores.size())
			done = true;
	}
}

