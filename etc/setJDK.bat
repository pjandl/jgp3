@ECHO OFF
REM *
REM * Java - Guia do Programador - 3a Ed.
REM * Autor: Peter Jandl Junior
REM * (c) 2015, Novatec Editora Ltda.
REM * 
REM * setJDK.bat
REM *
echo ----------------------------------------
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_31
echo JAVA_HOME = %JAVA_HOME%
echo ----------------------------------------
set PATH=%JAVA_HOME%\bin;%path%
echo PATH = %PATH%
echo ----------------------------------------
set CLASSPATH=.;%classpath%
echo CLASSPATH = %CLASSPATH%
echo ----------------------------------------
