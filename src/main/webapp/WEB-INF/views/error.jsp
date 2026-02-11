
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
html
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Ошибка валидации данных</title>
    <style>
        :root {
            --primary-color: #dc3545;
            --secondary-color: #6c757d;
            --light-bg: #f8f9fa;
        }

        body {
            margin: 0;
            padding: 0;
            font-family: system-ui, -apple-system, sans-serif;
            background: var(--light-bg);
            color: #333;
            line-height: 1.6;
        }

        .error-wrapper {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            padding: 20px;
        }

        .error-box {
            background: white;
            border-radius: 12px;
            padding: 40px;
            width: 100%;
            max-width: 450px;
            text-align: center;
            box-shadow: 0 4px 20px rgba(0,0,0,0.08);
            border-top: 5px solid var(--primary-color);
        }

        .error-header {
            margin-bottom: 25px;
        }

        .error-icon {
            width: 70px;
            height: 70px;
            background: #fff5f5;
            border-radius: 50%;
            display: inline-flex;
            align-items: center;
            justify-content: center;
            margin-bottom: 20px;
        }

        .error-icon::before {
            content: "!";
            font-size: 32px;
            font-weight: bold;
            color: var(--primary-color);
        }

        h1 {
            color: var(--primary-color);
            margin: 0 0 15px 0;
            font-size: 24px;
        }

        .error-description {
            color: var(--secondary-color);
            margin-bottom: 30px;
            font-size: 15px;
        }

        .action-buttons {
            display: flex;
            gap: 12px;
            justify-content: center;
            flex-wrap: wrap;
        }

        .btn {
            padding: 12px 24px;
            border-radius: 6px;
            text-decoration: none;
            font-weight: 500;
            border: none;
            cursor: pointer;
            font-size: 15px;
            transition: all 0.2s;
            min-width: 140px;
        }

        .btn-primary {
            background: var(--primary-color);
            color: white;
        }

        .btn-primary:hover {
            background: #c82333;
            transform: translateY(-1px);
        }

        .btn-secondary {
            background: var(--secondary-color);
            color: white;
        }

        .btn-secondary:hover {
            background: #5a6268;
            transform: translateY(-1px);
        }

        .error-tips {
            margin-top: 30px;
            padding-top: 20px;
            border-top: 1px solid #eee;
            font-size: 14px;
            color: #666;
            text-align: left;
        }

        .error-tips h3 {
            margin-top: 0;
            font-size: 15px;
            color: #444;
        }

        .error-tips ul {
            padding-left: 20px;
            margin: 10px 0 0 0;
        }

        .error-tips li {
            margin-bottom: 8px;
        }
    </style>
</head>
<body>
<div class="error-wrapper">
    <div class="error-box">
        <div class="error-header">
            <div class="error-icon"></div>
            <h1>Ошибка в данных</h1>
            <p class="error-description">
                Введенные данные содержат ошибки или не соответствуют требованиям системы
            </p>
        </div>

        <div class="action-buttons">
            <button class="btn btn-primary" onclick="goBack()">
                ← Назад к форме
            </button>
            <button class="btn btn-secondary" onclick="goHome()">
                Домой
            </button>
        </div>

        <div class="error-tips">
            <h3>Что проверить:</h3>
            <ul>
                <li>Все ли обязательные поля заполнены</li>
                <li>Корректность email и телефона</li>
                <li>Соответствие пароля требованиям</li>
                <li>Формат дат и чисел</li>
            </ul>
        </div>
    </div>
</div>

<script>
    function goBack() {
        if (document.referrer && !document.referrer.includes(window.location.hostname)) {
            window.history.back();
        } else if (document.referrer) {
            window.location.href = document.referrer;
        } else {
            window.history.back();
        }
    }

    function goHome() {
        window.location.href = '/';
    }
</script>
</body>
</html>
