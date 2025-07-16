package dongcom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dongcom.modal.PaymentOrder;

public interface PaymentOrderRepository extends JpaRepository<PaymentOrder, Long> {

    PaymentOrder findByPaymentId(String paymentLinkId);
}
