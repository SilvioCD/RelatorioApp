@echo off
chcp 65001 >nul
setlocal enabledelayedexpansion

set "resPath=app\src\main\res"

echo Limpando arquivos desktop.ini em %resPath%...

:: Limpa desktop.ini na pasta raiz
if exist "%resPath%\desktop.ini" (
    attrib -s -h "%resPath%\desktop.ini"
    del /f /q "%resPath%\desktop.ini"
)

:: Limpa desktop.ini em subpastas
echo Limpando subpastas...
for /f "delims=" %%f in ('dir /b /s /a:-d "%resPath%\desktop.ini" 2^>nul') do (
    attrib -s -h "%%f"
    del /f /q "%%f"
)

:: Protege SOMENTE a pasta res (sem /s /d)
echo Aplicando proteção contra recriação do desktop.ini...
attrib +r "%resPath%"

echo.
echo ✅ Concluído! Pasta protegida contra desktop.ini.
pause
