package dongcom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

import dongcom.domain.PaymentOrderStatus;
import dongcom.modal.PaymentOrder;
import dongcom.payload.PaymentLinkResponse;
import dongcom.payload.payload_dto.BookingDTO;
import dongcom.payload.payload_dto.UserDTO;
import dongcom.service.PaymentService;
import lombok.RequiredArgsConstructor;
import okhttp3.Response;
import dongcom.domain.PaymentMethod;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<PaymentLinkResponse> createPaymentLink(
            @RequestBody BookingDTO booking,
            @RequestParam PaymentMethod paymentMethod) throws StripeException, RazorpayException {

        UserDTO user = new UserDTO();
        user.setFullName("");
        user.setEmail("");
        user.setId(1L);

        PaymentLinkResponse res = paymentService.createOrder(user, booking, paymentMethod);

        return ResponseEntity.ok(res);
    }

    @GetMapping("/paymentOrderId")
    public ResponseEntity<PaymentOrder> getPaymentOrderById(
            @PathVariable Long paymentOrderId) throws Exception {

        PaymentOrder res = paymentService.getPaymentOrderById(paymentOrderId);

        return ResponseEntity.ok(res);
    }

    @GetMapping("/paymentOrderId")
    public ResponseEntity<PaymentOrder> processPayment(
            @PathVariable Long paymentOrderId) throws Exception {

        PaymentOrder res = paymentService.getPaymentOrderById(paymentOrderId);

        return ResponseEntity.ok(res);
    }
}
