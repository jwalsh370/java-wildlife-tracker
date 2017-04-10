--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.3
-- Dumped by pg_dump version 9.5.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: animals; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE animals (
    id integer NOT NULL,
    name character varying,
    viewdate timestamp without time zone,
    ranger_id integer
);


ALTER TABLE animals OWNER TO "Guest";

--
-- Name: animals_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE animals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE animals_id_seq OWNER TO "Guest";

--
-- Name: animals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE animals_id_seq OWNED BY animals.id;


--
-- Name: animalviews; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE animalviews (
    id integer NOT NULL,
    name character varying,
    viewdate timestamp without time zone,
    range integer
);


ALTER TABLE animalviews OWNER TO "Guest";

--
-- Name: animalviews_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE animalviews_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE animalviews_id_seq OWNER TO "Guest";

--
-- Name: animalviews_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE animalviews_id_seq OWNED BY animalviews.id;


--
-- Name: endangered_animals; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE endangered_animals (
    id integer NOT NULL,
    name character varying,
    health character varying,
    age character varying,
    viewdate timestamp without time zone,
    ranger_id integer
);


ALTER TABLE endangered_animals OWNER TO "Guest";

--
-- Name: endangered_animals_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE endangered_animals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE endangered_animals_id_seq OWNER TO "Guest";

--
-- Name: endangered_animals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE endangered_animals_id_seq OWNED BY endangered_animals.id;


--
-- Name: rangers; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE rangers (
    id integer NOT NULL,
    name character varying,
    email character varying,
    badgenumber integer,
    viewdate timestamp without time zone
);


ALTER TABLE rangers OWNER TO "Guest";

--
-- Name: rangers_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE rangers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE rangers_id_seq OWNER TO "Guest";

--
-- Name: rangers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE rangers_id_seq OWNED BY rangers.id;


--
-- Name: sightings; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE sightings (
    id integer NOT NULL,
    animal_id integer,
    location character varying,
    ranger_name character varying,
    viewdate timestamp without time zone,
    ranger_id integer
);


ALTER TABLE sightings OWNER TO "Guest";

--
-- Name: sightings_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE sightings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sightings_id_seq OWNER TO "Guest";

--
-- Name: sightings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE sightings_id_seq OWNED BY sightings.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY animals ALTER COLUMN id SET DEFAULT nextval('animals_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY animalviews ALTER COLUMN id SET DEFAULT nextval('animalviews_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY endangered_animals ALTER COLUMN id SET DEFAULT nextval('endangered_animals_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY rangers ALTER COLUMN id SET DEFAULT nextval('rangers_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY sightings ALTER COLUMN id SET DEFAULT nextval('sightings_id_seq'::regclass);


--
-- Data for Name: animals; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY animals (id, name, viewdate, ranger_id) FROM stdin;
1	spider	2017-04-10 13:45:49.874948	\N
\.


--
-- Name: animals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('animals_id_seq', 1, true);


--
-- Data for Name: animalviews; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY animalviews (id, name, viewdate, range) FROM stdin;
\.


--
-- Name: animalviews_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('animalviews_id_seq', 1, false);


--
-- Data for Name: endangered_animals; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY endangered_animals (id, name, health, age, viewdate, ranger_id) FROM stdin;
1	Canine	Okay	Young	\N	\N
2	Marsupial	Okay	Young	2017-04-07 12:15:45.631677	\N
3	chupacabra	Ill	Adult	2017-04-07 12:41:36.693127	\N
\.


--
-- Name: endangered_animals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('endangered_animals_id_seq', 3, true);


--
-- Data for Name: rangers; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY rangers (id, name, email, badgenumber, viewdate) FROM stdin;
1	rick	\N	\N	2017-04-07 12:22:09.824371
2	Ron	\N	\N	2017-04-07 12:26:56.971916
3	Roland	rollon@roland.com	443	\N
4	Ron	\N	\N	2017-04-07 12:41:07.240814
5	jon	\N	\N	2017-04-07 12:48:21.934154
6	rick	rickityrick@ricky.com	451	2017-04-07 12:50:19.378431
7	Rick	rickityRick@ricky.com	444	2017-04-10 12:42:04.936072
8	jahan	jwal	123	2017-04-10 12:56:34.696095
9	jwalsh	jwals370	3332	2017-04-10 12:58:49.235021
10	new	email	111	2017-04-10 12:59:05.520401
11	tyrone	ttime@tt.com	554	2017-04-10 13:00:49.113527
12	rick	rickityRick@ricky.com	222	2017-04-10 13:28:13.548105
13	rick	rickityRick@ricky.com	222	2017-04-10 13:30:04.64578
14	Rick	rickityRick@ricky.com	356	2017-04-10 13:45:32.920075
\.


--
-- Name: rangers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('rangers_id_seq', 14, true);


--
-- Data for Name: sightings; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY sightings (id, animal_id, location, ranger_name, viewdate, ranger_id) FROM stdin;
1	1	Michigan	Juniper	\N	\N
\.


--
-- Name: sightings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('sightings_id_seq', 1, true);


--
-- Name: animals_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);


--
-- Name: animalviews_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY animalviews
    ADD CONSTRAINT animalviews_pkey PRIMARY KEY (id);


--
-- Name: endangered_animals_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY endangered_animals
    ADD CONSTRAINT endangered_animals_pkey PRIMARY KEY (id);


--
-- Name: rangers_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY rangers
    ADD CONSTRAINT rangers_pkey PRIMARY KEY (id);


--
-- Name: sightings_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY sightings
    ADD CONSTRAINT sightings_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: epicodus
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM epicodus;
GRANT ALL ON SCHEMA public TO epicodus;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

