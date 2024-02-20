insert into agreement(id, status)
values (nextval('agreement_seq'), :status)
returning id, status