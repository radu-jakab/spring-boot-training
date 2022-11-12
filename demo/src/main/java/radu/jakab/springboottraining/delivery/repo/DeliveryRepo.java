package radu.jakab.springboottraining.delivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import radu.jakab.springboottraining.delivery.model.Delivery;
import radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum;

import java.util.List;

@Repository
public interface DeliveryRepo extends
        JpaRepository<Delivery, String>,
        QuerydslPredicateExecutor<Delivery>,
        JpaSpecificationExecutor<Delivery> {

    List<Delivery> findAllByStatusEquals(DeliveryStatusEnum status);

    @Query("""
                        select d from Delivery d where d.status in 
                        (radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum.NEW,
                        radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum.ASSIGNED,
                        radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum.PICKED_UP)
            """)
    List<Delivery> queryAllOngoingDeliveries();

    @Query(value = """
                        select d.* from Delivery d 
                        where d.status in 
                                (radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum.NEW,
                                radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum.ASSIGNED,
                                radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum.PICKED_UP)
                            and d.expectedDeliveryTime>current_timestamp
            """, nativeQuery = true)
    List<Delivery> queryAllOngoingLateDeliveries();

    @Query("""
                        select d from Delivery d
                        where d.status in 
                            (radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum.NEW,
                            radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum.ASSIGNED,
                            radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum.PICKED_UP)
                           and d.courier.id=:id
            """)
    List<Delivery> queryAllOngoingDeliveriesForCourierId(@Param("id") String id);

}
