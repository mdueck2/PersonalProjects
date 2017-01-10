#ifndef HIGHSCORES_H
#define HIGHSCORES_H

#include <QDialog>
#include "mainwindow.h"

namespace Ui {
class HighScores;
}

class HighScores : public QDialog
{
    Q_OBJECT

public:
    explicit HighScores(QWidget *parent = 0, std::vector<Score>* scores = nullptr);
    ~HighScores();

private slots:
    void on_exitButton_clicked();
	void resizeEvent(QResizeEvent* event);

private:
    Ui::HighScores *ui;
};

#endif // HIGHSCORES_H
