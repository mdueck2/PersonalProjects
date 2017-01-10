#-------------------------------------------------
#
# Project created by QtCreator 2016-12-08T18:38:33
#
#-------------------------------------------------

QT       += core gui

greaterThan(QT_MAJOR_VERSION, 4): QT += widgets

TARGET = SearchAlgorithms
TEMPLATE = app


SOURCES += main.cpp\
        mainwindow.cpp \
    BubbleSort.cpp \
    highscores.cpp

HEADERS  += mainwindow.h \
    BubbleSort.h \
    Include.h \
    highscores.h

FORMS    += mainwindow.ui \
    highscores.ui
