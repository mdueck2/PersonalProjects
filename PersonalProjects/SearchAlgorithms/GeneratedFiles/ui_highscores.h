/********************************************************************************
** Form generated from reading UI file 'highscores.ui'
**
** Created by: Qt User Interface Compiler version 5.7.0
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_HIGHSCORES_H
#define UI_HIGHSCORES_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QDialog>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QVBoxLayout>

QT_BEGIN_NAMESPACE

class Ui_HighScores
{
public:
    QVBoxLayout *verticalLayout;
    QLabel *label;
    QPushButton *exitButton;

    void setupUi(QDialog *HighScores)
    {
        if (HighScores->objectName().isEmpty())
            HighScores->setObjectName(QStringLiteral("HighScores"));
        HighScores->resize(168, 199);
        QSizePolicy sizePolicy(QSizePolicy::MinimumExpanding, QSizePolicy::MinimumExpanding);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(0);
        sizePolicy.setHeightForWidth(HighScores->sizePolicy().hasHeightForWidth());
        HighScores->setSizePolicy(sizePolicy);
        HighScores->setMaximumSize(QSize(200, 200));
        HighScores->setSizeIncrement(QSize(0, 0));
        HighScores->setBaseSize(QSize(0, 0));
        verticalLayout = new QVBoxLayout(HighScores);
        verticalLayout->setObjectName(QStringLiteral("verticalLayout"));
        label = new QLabel(HighScores);
        label->setObjectName(QStringLiteral("label"));
        label->setEnabled(true);
        QSizePolicy sizePolicy1(QSizePolicy::Expanding, QSizePolicy::Expanding);
        sizePolicy1.setHorizontalStretch(0);
        sizePolicy1.setVerticalStretch(0);
        sizePolicy1.setHeightForWidth(label->sizePolicy().hasHeightForWidth());
        label->setSizePolicy(sizePolicy1);
        label->setMinimumSize(QSize(150, 150));
        label->setMaximumSize(QSize(450, 450));
        label->setScaledContents(true);
        label->setAlignment(Qt::AlignCenter);

        verticalLayout->addWidget(label);

        exitButton = new QPushButton(HighScores);
        exitButton->setObjectName(QStringLiteral("exitButton"));
        QSizePolicy sizePolicy2(QSizePolicy::Minimum, QSizePolicy::Minimum);
        sizePolicy2.setHorizontalStretch(0);
        sizePolicy2.setVerticalStretch(0);
        sizePolicy2.setHeightForWidth(exitButton->sizePolicy().hasHeightForWidth());
        exitButton->setSizePolicy(sizePolicy2);
        exitButton->setMinimumSize(QSize(100, 25));
        exitButton->setMaximumSize(QSize(0, 0));

        verticalLayout->addWidget(exitButton, 0, Qt::AlignHCenter|Qt::AlignVCenter);


        retranslateUi(HighScores);

        QMetaObject::connectSlotsByName(HighScores);
    } // setupUi

    void retranslateUi(QDialog *HighScores)
    {
        HighScores->setWindowTitle(QApplication::translate("HighScores", "Dialog", 0));
        label->setText(QString());
        exitButton->setText(QApplication::translate("HighScores", "Exit", 0));
    } // retranslateUi

};

namespace Ui {
    class HighScores: public Ui_HighScores {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_HIGHSCORES_H
