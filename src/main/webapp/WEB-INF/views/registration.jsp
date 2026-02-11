
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Регистрация</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }

        .container {
            background: white;
            border-radius: 15px;
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            width: 100%;
            max-width: 800px;
        }

        .header {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 30px;
            text-align: center;
        }

        .header h1 {
            font-size: 2.5rem;
            margin-bottom: 10px;
        }

        .header p {
            opacity: 0.9;
        }

        .form-container {
            padding: 40px;
        }

        .form-row {
            display: flex;
            gap: 20px;
            margin-bottom: 25px;
        }

        .form-group {
            flex: 1;
            margin-bottom: 0;
        }

        .form-section {
            margin-bottom: 40px;
        }

        .section-title {
            font-size: 1.3rem;
            color: #333;
            margin-bottom: 20px;
            padding-bottom: 10px;
            border-bottom: 2px solid #667eea;
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .section-title i {
            color: #667eea;
        }

        .form-group {
            margin-bottom: 25px;
        }

        .form-group label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
            color: #555;
            font-size: 0.95rem;
        }

        .required:after {
            content: " *";
            color: #e74c3c;
        }

        .form-control {
            width: 100%;
            padding: 12px 15px;
            border: 2px solid #e1e5e9;
            border-radius: 8px;
            font-size: 1rem;
            transition: all 0.3s ease;
        }

        .form-control:focus {
            outline: none;
            border-color: #667eea;
            box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.1);
        }

        .radio-group {
            display: flex;
            gap: 20px;
            flex-wrap: wrap;
        }

        .radio-option {
            display: flex;
            align-items: center;
            gap: 8px;
        }

        .radio-option input[type="radio"] {
            width: 18px;
            height: 18px;
        }

        .error-message {
            color: #e74c3c;
            font-size: 0.85rem;
            margin-top: 5px;
            display: flex;
            align-items: center;
            gap: 5px;
        }

        .success-message {
            background: #2ecc71;
            color: white;
            padding: 15px;
            border-radius: 8px;
            margin-bottom: 20px;
            text-align: center;
        }

        .btn-submit {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            border: none;
            padding: 16px 40px;
            border-radius: 8px;
            font-size: 1.1rem;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            width: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 10px;
        }

        .btn-submit:hover {
            transform: translateY(-2px);
            box-shadow: 0 10px 20px rgba(102, 126, 234, 0.2);
        }

        .btn-submit:active {
            transform: translateY(0);
        }

        .form-footer {
            text-align: center;
            margin-top: 30px;
            padding-top: 20px;
            border-top: 1px solid #eee;
        }

        .form-footer a {
            color: #667eea;
            text-decoration: none;
            font-weight: 600;
        }

        .form-footer a:hover {
            text-decoration: underline;
        }

        .password-strength {
            margin-top: 5px;
            height: 4px;
            background: #eee;
            border-radius: 2px;
            overflow: hidden;
        }

        .password-strength-bar {
            height: 100%;
            width: 0%;
            transition: width 0.3s ease, background 0.3s ease;
        }

        @media (max-width: 768px) {
            .form-row {
                flex-direction: column;
                gap: 0;
            }

            .container {
                margin: 20px;
            }

            .form-container {
                padding: 30px 20px;
            }
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
<div class="container">
    <div class="header">
        <h1><i class="fas fa-user-plus"></i> Регистрация</h1>
        <p>Создайте новый аккаунт для доступа к системе</p>
    </div>

    <div class="form-container">

        <form action="/security/registration" method="post" id="registrationForm">

            <!-- Секция: Информация о пользователе -->
            <div class="form-section">
                <div class="section-title">
                    <i class="fas fa-user"></i>
                    <span>Личная информация</span>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label for="firstName" class="required">Имя</label>
                        <input type="text"
                               id="firstName"
                               name="firstName"
                               class="form-control"
                               placeholder="Введите ваше имя"
                               required>
                    </div>

                    <div class="form-group">
                        <label for="lastName" class="required">Фамилия</label>
                        <input type="text"
                               id="lastName"
                               name="lastName"
                               class="form-control"
                               placeholder="Введите вашу фамилию"
                               required>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label for="email" class="required">Email</label>
                        <input type="email"
                               id="email"
                               name="email"
                               class="form-control"
                               placeholder="example@mail.com"
                               required>
                    </div>

                    <div class="form-group">
                        <label for="age" class="required">Возраст</label>
                        <input type="number"
                               id="age"
                               name="age"
                               class="form-control"
                               value="${param.age}"
                               placeholder="Введите ваш возраст"
                               min="1"
                               max="120"
                               required>

                    </div>
                </div>
            </div>

            <!-- Секция: Учетные данные -->
            <div class="form-section">
                <div class="section-title">
                    <i class="fas fa-shield-alt"></i>
                    <span>Учетные данные</span>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label for="username" class="required">Имя пользователя</label>
                        <input type="text"
                               id="username"
                               name="username"
                               class="form-control"
                               placeholder="Придумайте логин"
                               required>
                    </div>

                    <div class="form-group">
                        <label for="userId">ID пользователя (опционально)</label>
                        <input type="text"
                               id="userId"
                               name="userId"
                               class="form-control"
                               placeholder="Внешний ID пользователя">
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label for="password" class="required">Пароль</label>
                        <input type="password"
                               id="password"
                               name="password"
                               class="form-control"
                               placeholder="Создайте пароль"
                               required>
                        <div class="password-strength">
                            <div class="password-strength-bar" id="passwordStrengthBar"></div>
                        </div>

                    </div>

                    <div class="form-group">
                        <label for="confirmPassword" class="required">Подтверждение пароля</label>
                        <input type="password"
                               id="confirmPassword"
                               name="confirmPassword"
                               class="form-control"
                               placeholder="Повторите пароль"
                               required>
                        <div id="passwordMatchMessage" class="error-message" style="display: none;">
                            <i class="fas fa-exclamation-circle"></i> Пароли не совпадают
                        </div>
                    </div>
                </div>
            </div>

            <!-- Кнопка отправки -->
            <button type="submit" class="btn-submit">
                <i class="fas fa-user-plus"></i> Зарегистрироваться
            </button>

            <div class="form-footer">
                <p>Уже есть аккаунт? <a href="login.jsp">Войдите здесь</a></p>
            </div>
        </form>
    </div>
</div>

<script>
    // Проверка совпадения паролей
    const passwordInput = document.getElementById('password');
    const confirmPasswordInput = document.getElementById('confirmPassword');
    const passwordMatchMessage = document.getElementById('passwordMatchMessage');
    const passwordStrengthBar = document.getElementById('passwordStrengthBar');

    function checkPasswordMatch() {
        if (passwordInput.value && confirmPasswordInput.value) {
            if (passwordInput.value !== confirmPasswordInput.value) {
                passwordMatchMessage.style.display = 'flex';
                return false;
            } else {
                passwordMatchMessage.style.display = 'none';
                return true;
            }
        }
        return true;
    }

    function checkPasswordStrength() {
        const password = passwordInput.value;
        let strength = 0;

        if (password.length >= 8) strength += 25;
        if (/[A-Z]/.test(password)) strength += 25;
        if (/[0-9]/.test(password)) strength += 25;
        if (/[^A-Za-z0-9]/.test(password)) strength += 25;

        passwordStrengthBar.style.width = strength + '%';

        if (strength < 50) {
            passwordStrengthBar.style.background = '#e74c3c';
        } else if (strength < 75) {
            passwordStrengthBar.style.background = '#f39c12';
        } else {
            passwordStrengthBar.style.background = '#2ecc71';
        }
    }

    passwordInput.addEventListener('input', checkPasswordStrength);
    confirmPasswordInput.addEventListener('input', checkPasswordMatch);
    passwordInput.addEventListener('input', checkPasswordMatch);

    // Валидация формы
    document.getElementById('registrationForm').addEventListener('submit', function(e) {
        // Проверка паролей
        if (!checkPasswordMatch()) {
            e.preventDefault();
            confirmPasswordInput.focus();
            return;
        }

        // Проверка возраста
        const ageInput = document.getElementById('age');
        const age = parseInt(ageInput.value);
        if (age < 1 || age > 120) {
            e.preventDefault();
            alert('Возраст должен быть от 1 до 120 лет');
            ageInput.focus();
            return;
        }

        // Проверка пароля на минимальную длину
        if (passwordInput.value.length < 6) {
            e.preventDefault();
            alert('Пароль должен содержать минимум 6 символов');
            passwordInput.focus();
            return;
        }
    });

    // Проверка email в реальном времени
    const emailInput = document.getElementById('email');
    emailInput.addEventListener('blur', function() {
        const email = emailInput.value;
        if (email && !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
            emailInput.style.borderColor = '#e74c3c';
        } else {
            emailInput.style.borderColor = '#e1e5e9';
        }
    });
</script>
</body>
</html>
</body>
</html>
