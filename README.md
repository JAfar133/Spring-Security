# Spring-Security
Educational Spring Security app with roles

# Описание
Приложение представляет собой подробный прогноз погоды с функцие авторизации. В приложении реализовано 3 роли `ROLE_GUEST` , `ROLE_USER` и `ROLE_ADMIN` . На странице гостя показан прогноз погоды в интересущем городе на текущий момент времени. У авторизованнног пользователя показан подробный проноз погоды на 4 дня с яндекс картой. У админа есть доступ к странице с таблицей пользователей, где он может назначать пользователя админом или удалять его из БД. Пароль зашифрован с помощью `BCryptPasswordEncoder`

### Использованные технологии:
- PostreSQL
- Spring JPA
- Spring Secutiry
- Thymeleaf
- Bootstrap
- Spring Validation
- Open Weather API
- Yandex Maps API

![image](https://user-images.githubusercontent.com/44347128/221907542-2a23c8d1-6502-4e01-a2c1-e3031af962a1.png)

![image](https://user-images.githubusercontent.com/44347128/221907588-3047b6ba-6e64-45c1-957b-db2aaf929e9b.png)

![image](https://user-images.githubusercontent.com/44347128/221907156-f8a6dc4b-a520-46bb-86dd-3ae984e0eb2e.png)

![image](https://user-images.githubusercontent.com/44347128/221907684-8f2e1468-41b6-45cc-b3c2-7906dd71f6cb.png)
