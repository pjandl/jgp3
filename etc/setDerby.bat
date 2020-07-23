@ECHO OFF
REM *
REM * Java - Guia do Programador - 3a Ed.
REM * Autor: Peter Jandl Junior
REM * (c) 2015, Novatec Editora Ltda.
REM * 
REM * setDerby.bat
REM *
if %DERBY_HOME%.==. call setJDK.bat
echo ----------------------------------------
set DERBY_HOME=%JAVA_HOME%\db
echo DERBY_HOME = %DERBY_HOME%
echo ----------------------------------------
set PATH=%DERBY_HOME%\bin;%path%
echo PATH = %PATH%
echo ----------------------------------------
set CLASSPATH=%DERBY_HOME%\lib\derbyclient.jar;%classpath%
echo CLASSPATH = %CLASSPATH%
echo ----------------------------------------
