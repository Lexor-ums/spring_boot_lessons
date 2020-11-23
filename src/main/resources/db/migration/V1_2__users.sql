CREATE TABLE IF NOT EXISTS actor
(
    id BIGSERIAL PRIMARY KEY,
    login character varying(255) UNIQUE NOT NULL,
    password character varying(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS role
(
    id BIGSERIAL PRIMARY KEY,
    name character varying(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS permission
(
    id BIGSERIAL PRIMARY KEY,
    name character varying(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS actor_role
(
    id BIGSERIAL PRIMARY KEY,
    actor_id bigint,
    role_id bigint,
    FOREIGN KEY (actor_id) REFERENCES actor(id),
    FOREIGN KEY (role_id) REFERENCES role(id)
);

CREATE TABLE IF NOT EXISTS role_rermission
(
    id BIGSERIAL PRIMARY KEY,
    role_id bigint,
    permission_id bigint,
    FOREIGN KEY (role_id) REFERENCES role(id),
    FOREIGN KEY (permission_id) REFERENCES permission(id)
);

insert into actor (login, password)values ('admin', 'MQ==');
insert into actor (login, password)values ('guest', 'Mg==');

insert into role (name)values ('admin');
insert into role (name)values ('guest');

insert into permission (name)values ('request_perm');
insert into permission (name)values ('log_perm');

insert into actor_role (actor_id, role_id) values (1, 1);
insert into actor_role (actor_id, role_id) values (2, 2);

insert into role_rermission (role_id, permission_id) values (1, 1);
insert into role_rermission (role_id, permission_id) values (1, 2);
insert into role_rermission (role_id, permission_id) values (2, 2);