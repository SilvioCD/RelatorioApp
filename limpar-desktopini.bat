@echo off
echo Removendo todos os arquivos desktop.ini do projeto...
for /r %%i in (desktop.ini) do del "%%i"
echo Concluído!
pause
