package reactor.netty.tcp;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Optional;

public class InetSocketAddressResolver {

  public static InetSocketAddress resolve(String hostname, int port, DnsNameResolver dnsNameResolver) {
    return resolved(IpHostnameInetSocketAddressResolver.resolve(hostname), port).orElseGet(() ->
        resolved(dnsNameResolver.resolve(hostname), port).orElseGet(() ->
            InetSocketAddress.createUnresolved(hostname, port)));
  }

  private static Optional<InetSocketAddress> resolved(Optional<InetAddress> inetAddress, int port) {
    return inetAddress.map(resolvedHostname -> new InetSocketAddress(resolvedHostname, port));
  }
}
