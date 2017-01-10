#include "highscores.h"
#include "ui_highscores.h"
#include <iostream>
#include "mainwindow.h"


HighScores::HighScores(QWidget *parent, std::vector<Score>* scores) :
	QDialog(parent),
	ui(new Ui::HighScores)
{
	ui->setupUi(this);
	ui->label->setStyleSheet("background-image: url(./shelly_50sml.png)");
	this->setWindowTitle("High Scores");
	if(scores->size() > 1)
	{
		std::string s = "";
		for(int i = 0; i < scores->size(); i++)
		{
			Score sc = scores->at(i);
			s += sc.name.toStdString() + "\t\t\t\t" + std::to_string(sc.score) + "\n";
		}
		ui->label->setText(QString::fromStdString(s));
		QFont font = ui->label->font();
		font.setPointSize(12);
		ui->label->setFont(font);
	}
}

HighScores::~HighScores()
{
	delete ui;
}

void HighScores::on_exitButton_clicked()
{
	reject();
}

/*
 * resizes shelly, maintaining aspect ratio
 */
void HighScores::resizeEvent(QResizeEvent* event)
{
	int d = std::min(this->width()-22, this->height()-53);
	ui->label->setMaximumHeight(d);
	ui->label->setMaximumWidth(d);
}
