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
