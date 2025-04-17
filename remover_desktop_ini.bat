@echo off
echo Procurando e removendo todos os arquivos desktop.ini...

REM Força a remoção de arquivos ocultos e de sistema
for /r %%i in (desktop.ini) do (
    attrib -h -s "%%i"
    del /f /q "%%i"
)

echo Todos os arquivos desktop.ini foram removidos.
pause
