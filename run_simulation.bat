@echo off

:: Проверка наличия Java
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo Java не найдена. Пожалуйста, установите Java и попробуйте снова.
    exit /b 1
)

:: Создание директории для классов, если её нет
if not exist out (
    mkdir out
)

:: Компиляция исходных файлов
echo Компиляция исходных файлов...
javac -d out -sourcepath src src\*.java
if %errorlevel% neq 0 (
    echo Ошибка компиляции. Проверьте код на наличие ошибок.
    exit /b 1
)
echo Компиляция завершена.

:: Запуск симуляции
echo Запуск симуляции...
java -cp out EcosystemApp
if %errorlevel% neq 0 (
    echo Ошибка запуска программы.
    exit /b 1
)
echo Симуляция завершена успешно.
pause
