package reactor.netty.tcp;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

import io.netty.util.NetUtil;

public class IpHostnameInetSocketAddressResolver {

  static Optional<InetAddress> resolve(String hostname) {
    return Optional.ofNullable(NetUtil.createByteArrayFromIpAddressString(hostname))
        .flatMap(IpHostnameInetSocketAddressResolver::resolveIpAddressInBytes);
  }

  private static Optional<InetAddress> resolveIpAddressInBytes(byte[] ipAddressBytes) {
    try {
      if (ipAddressBytes.length == 4) {
        return Optional.of(Inet4Address.getByAddress(ipAddressBytes));
      } else {
        return Optional.of(Inet6Address.getByAddress(null, ipAddressBytes, -1));
      }
    } catch (UnknownHostException e) {
      return Optional.empty();
    }
  }
}
