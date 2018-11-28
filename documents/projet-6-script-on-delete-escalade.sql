-- TABLE COMMENTAIRE
ALTER TABLE public.commentaire DROP CONSTRAINT utilisateur_commentaire_fk;
ALTER TABLE public.commentaire
ADD CONSTRAINT utilisateur_commentaire_fk
FOREIGN KEY (utilisateur_id) REFERENCES public.utilisateur (id) ON DELETE CASCADE;

-- TABLE COMMENTAIRE SUR SITE
ALTER TABLE public.commentaire_sur_site DROP CONSTRAINT site_commentaire_sur_site_fk;
ALTER TABLE public.commentaire_sur_site
ADD CONSTRAINT site_commentaire_sur_site_fk
FOREIGN KEY (site_id) REFERENCES public.site (id) ON DELETE CASCADE;

ALTER TABLE public.commentaire_sur_site DROP CONSTRAINT commentaire_commentaire_sur_site_fk;
ALTER TABLE public.commentaire_sur_site
ADD CONSTRAINT commentaire_commentaire_sur_site_fk
FOREIGN KEY (commentaire_id) REFERENCES public.commentaire (id) ON DELETE CASCADE;

-- TABLE COMMENTAIRE SUR TOPO
ALTER TABLE public.commentaire_sur_topo DROP CONSTRAINT topo_commentaire_sur_topo_fk;
ALTER TABLE public.commentaire_sur_topo
ADD CONSTRAINT topo_commentaire_sur_topo_fk
FOREIGN KEY (topo_id) REFERENCES public.topo (id) ON DELETE CASCADE;

ALTER TABLE public.commentaire_sur_topo DROP CONSTRAINT commentaire_commentaire_sur_topo_fk;
ALTER TABLE public.commentaire_sur_topo
ADD CONSTRAINT commentaire_commentaire_sur_topo_fk
FOREIGN KEY (commentaire_id) REFERENCES public.commentaire (id) ON DELETE CASCADE;

-- TABLE COMMENTAIRE SUR VOIE
ALTER TABLE public.commentaire_sur_voie DROP CONSTRAINT voie_commentaire_sur_voie_fk;
ALTER TABLE public.commentaire_sur_voie
ADD CONSTRAINT voie_commentaire_sur_voie_fk
FOREIGN KEY (voie_id) REFERENCES public.voie (id) ON DELETE CASCADE;

ALTER TABLE public.commentaire_sur_voie DROP CONSTRAINT commentaire_commentaire_sur_voie_fk;
ALTER TABLE public.commentaire_sur_voie
ADD CONSTRAINT commentaire_commentaire_sur_voie_fk
FOREIGN KEY (commentaire_id) REFERENCES public.commentaire (id) ON DELETE CASCADE;

-- TABLE COMPOSITION SITE TOPO
ALTER TABLE public.composition_site_topo DROP CONSTRAINT topo_site_associe_fk;
ALTER TABLE public.composition_site_topo
ADD CONSTRAINT topo_site_associe_fk
FOREIGN KEY (topo_id) REFERENCES public.topo (id) ON DELETE CASCADE;

ALTER TABLE public.composition_site_topo DROP CONSTRAINT site_site_associe_fk;
ALTER TABLE public.composition_site_topo
ADD CONSTRAINT site_site_associe_fk
FOREIGN KEY (site_id) REFERENCES public.site (id) ON DELETE CASCADE;

-- TABLE SECTEUR
ALTER TABLE public.secteur DROP CONSTRAINT site_secteur_fk;
ALTER TABLE public.secteur
ADD CONSTRAINT site_secteur_fk
FOREIGN KEY (site_id) REFERENCES public.site (id) ON DELETE CASCADE;

-- TABLE VOIE
ALTER TABLE public.voie DROP CONSTRAINT secteur_voie_fk;
ALTER TABLE public.voie
ADD CONSTRAINT secteur_voie_fk
FOREIGN KEY (secteur_id) REFERENCES public.secteur (id) ON DELETE CASCADE;