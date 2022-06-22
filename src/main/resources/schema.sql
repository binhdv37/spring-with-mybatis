create table if not exists permission
(
    id                    uuid                not null,
    name                varchar(255)        not null,
    key                 varchar(255)        not null,
    created_time           bigint              not null,
    constraint permission_pkey primary key(id)
);

create table if not exists role
(
    id                uuid                not null,
    name              varchar(255)        not null,
    created_time       bigint,
    created_by         uuid,
    updated_time       bigint,
    updated_by         uuid,
    constraint role_pkey primary key (id),
    constraint unique_role_name unique (name)
);

create table if not exists role_and_permission
(
    role_id           uuid                not null,
    permission_id     uuid                not null,
    constraint role_and_permission_pkey primary key(role_id, permission_id),
    constraint fk_roleandpermission_role foreign key (role_id) references role(id),
    constraint fk_roleandpermission_permission foreign key (permission_id) references permission(id)
);

create table if not exists app_user
(
    id                uuid                not null,
    username          varchar(255)        not null,
    password          varchar(255)        not null,
    email             varchar(255)        not null,
    full_name          varchar(255)        not null,
    phone_number       varchar(255),
    enable            bool                not null,
    created_time       bigint,
    created_by         uuid,
    updated_time       bigint,
    updated_by         uuid,
    role_id           uuid,
    constraint user_pkey primary key (id),
    constraint unique_username unique (username),
    constraint unique_email unique (email),
    constraint fk_user_role foreign key (role_id) references role(id)
);