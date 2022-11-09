package radu.jakab.springboottraining.delivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import radu.jakab.springboottraining.delivery.model.Delivery;
import radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface DeliveryRepo extends JpaRepository<Delivery, String>,
        QuerydslPredicateExecutor<Delivery>,
        JpaSpecificationExecutor<Delivery> {

    List<Delivery> findDeliveryByStatusIs(DeliveryStatusEnum status);

    @Query("""
                 select d from Delivery d where d.status in
                     (radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum.NEW,
                     radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum.ASSIGNED,
                     radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum.PICKED_UP)
            """)
    List<Delivery> getOngoingDeliveries();

    List<Delivery> findAllByStatusInAndExpectedDeliveryTimeAfter(List<DeliveryStatusEnum> statuses,
                                                                 ZonedDateTime after);

    @Query(value = """
                    select d.* from Delivery d
                    where d.status in ('NEW', 'ASSIGNED', 'PICKED_UP')
                        and d.courier_id=:courierId
            """, nativeQuery = true)
    List<Delivery> getOngoingDeliveriesByCourier(String courierId);
}
