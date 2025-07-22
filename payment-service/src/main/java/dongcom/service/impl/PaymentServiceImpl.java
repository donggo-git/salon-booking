package dongcom.service.impl;

import org.springframework.stereotype.Service;

import com.razorpay.PaymentLink;

import dongcom.domain.PaymentMethod;
import dongcom.modal.PaymentOrder;
import dongcom.payload.PaymentLinkResponse;
import dongcom.payload.payload_dto.BookingDTO;
import dongcom.payload.payload_dto.UserDTO;
import dongcom.repository.PaymentOrderRepository;
import dongcom.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentOrderRepository paymentOrderRepository;

    @Value("${stripe.api.key}")
    private String stripeSecretKey;

    @Value("${razor.api.key}")
    private String razorpayApiKey;

    @Value("${razor.api.secret}")
    private String razorpayApiSecret;

    @Override
    public PaymentLinkResponse createOrder(UserDTO user, BookingDTO booking, PaymentMethod paymentMethod) {
        // TODO Auto-generated method stub
        Long amount = (long) booking.getTotalPrice();
        PaymentOrder order = new PaymentOrder();
        order.setAmount(amount);
        order.setPaymentMethod(paymentMethod);
        order.setBookingId(booking.getId());
        order.setStudyId(booking.getStudyId());
        PaymentOrder savedOrder = paymentOrderRepository.save(order);

        PaymentLinkResponse paymentLinkResponse = new PaymentLinkResponse();

        if (paymentMethod.equals(PaymentMethod.RAZORPAY)) {
            PaymentLink payment = createRazorPaymentLink(user, savedOrder.getAmount(), savedOrder.getId());
            String paymentUrl = payment.get("short_url");
            String paymentUrlId = payment.get("id");
            paymentLinkResponse.setPayment_link_url(paymentUrl);
            paymentLinkResponse.setGetPayment_link_id(paymentUrlId);

            savedOrder.setPaymentLinkId(paymentUrlId);
        }
        throw new UnsupportedOperationException("Unimplemented method 'createOrder'");
    }

    @Override
    public PaymentOrder getPaymentOrderById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPaymentOrderById'");
    }

    @Override
    public PaymentOrder getPaymentOrderByPaymentId(String paymentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPaymentOrderByPaymentId'");
    }

    @Override
    public PaymentLink createRazorPaymentLink(UserDTO user, Long amount, Long orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createRazorPaymentLink'");
    }

    @Override
    public String createStripePaymentLink(UserDTO user, Long amount, Long orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createStripePaymentLink'");
    }

}
