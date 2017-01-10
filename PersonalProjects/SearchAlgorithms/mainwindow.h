#ifndef MAINWINDOW_H
#define MAINWINDOW_H


#include "ui_mainwindow.h"
#include <sstream>
#include <fstream>
#include <QInputDialog>
#include <QDir>


class HighScores;

namespace Ui {
class MainWindow;
}

struct Score
{
	QString name;
	int score;
};

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();
	std::vector<Score> scores;

private slots:
    void on_testButton_clicked();
	void on_actionQuit_triggered() { exit(0); };
	void on_actionHigh_Scores_triggered();
	void on_giveUpButton_clicked();

private:
    Ui::MainWindow *ui;
	std::fstream file;
	void sortScores();
};

#endif // MAINWINDOW_H
