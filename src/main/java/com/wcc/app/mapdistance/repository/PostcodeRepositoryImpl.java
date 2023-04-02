package com.wcc.app.mapdistance.repository;

import com.wcc.app.mapdistance.model.PostCodeLatLng;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.Objects;

@Repository
public class PostcodeRepositoryImpl implements PostcodeRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    /**
     * @param postCodeLatLng
     * @return
     */
    @Transactional
    @Override
    public int updatePostcode(PostCodeLatLng postCodeLatLng) {

        if(Objects.isNull(postCodeLatLng)) {
            return 0;
        }

        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaUpdate<PostCodeLatLng> update = cb.createCriteriaUpdate(PostCodeLatLng.class);
        Root<PostCodeLatLng> postCOdeLatlngClass = update.from(PostCodeLatLng.class);
        update.set("latitude", postCodeLatLng.getLatitude());
        update.set("longitude", postCodeLatLng.getLongitude());
        update.where(cb.equal(postCOdeLatlngClass.get("id"), postCodeLatLng.getId()));

        return this.em.createQuery(update).executeUpdate();
    }
}