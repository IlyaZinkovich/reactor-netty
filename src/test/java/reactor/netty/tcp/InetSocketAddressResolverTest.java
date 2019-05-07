package reactor.netty.tcp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.net.InetSocketAddress;

public class InetSocketAddressResolverTest {

  @Test
  public void shouldCreateResolvedNumericIPv4Address() {
    InetSocketAddress socketAddress =
        InetSocketAddressResolver.resolve("127.0.0.1", 8080, new DefaultDnsNameResolver());
    assertThat(socketAddress.isUnresolved()).isFalse();
    assertThat(socketAddress.getAddress().getHostAddress()).isEqualTo("127.0.0.1");
    assertThat(socketAddress.getPort()).isEqualTo(8080);
    assertThat(socketAddress.getHostString()).isEqualTo("127.0.0.1");
  }

  @Test
  public void shouldCreateResolvedNumericIPv6Address() {
    InetSocketAddress socketAddress =
        InetSocketAddressResolver.resolve("::1", 8080, new DefaultDnsNameResolver());
    assertThat(socketAddress.isUnresolved()).isFalse();
    assertThat(socketAddress.getAddress().getHostAddress())
        .isEqualTo("0:0:0:0:0:0:0:1");
    assertThat(socketAddress.getPort()).isEqualTo(8080);
    assertThat(socketAddress.getHostString()).isEqualTo("0:0:0:0:0:0:0:1");
  }
}
