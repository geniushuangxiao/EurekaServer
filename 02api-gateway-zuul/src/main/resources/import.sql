insert into user_authority (role) value ('ADMIN');
insert into user_authority (role) value ('USER');
insert into user (username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled) values ('admin', '$2a$10$zEGWBWMdNK7QPmVzovs0.Oh3cOMhdFj7.0HGqiMhGJn.ngxYbXN4C', true, true, true, true);
insert into user (username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled) values ('user', '$2a$10$qw6udoyFqa9iiOWqFh6dtuKbqCH2iYTiAwYdbuadfWrwLrMvwcR7q', true, true, true, true);
insert into user_user_authority (username, role) values ('admin', 'ADMIN');
insert into user_user_authority (username, role) values ('user', 'USER');