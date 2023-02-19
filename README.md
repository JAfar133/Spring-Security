# Spring-Security
Educational Spring Security app with roles

# Описание
В учебном приложении реализовано 2 роли `ROLE_USER` и `ROLE_ADMIN` , у админа есть доступ 
к таблице с пользователями, где он может назначать пользователя админом или удалять его из БД. Пароль зашифрован с помощью `BCryptPasswordEncoder`

### Использованные технологии:
- PostreSQL
- Spring JPA
- Spring Secutiry
- Thymeleaf
- Bootstrap
- Spring Validation
