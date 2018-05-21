@echo off

SET directory=C:\Users\Antonio\Dropbox\ESO - Evolution Soccer Online\Plantillas
FOR /F "delims=·" %%i IN (teams.dir) DO (

	@ECHO Copiando %%i

	copy "%directory%\%%i" "%CD%"
)

pause
