// import javax.sound.sampled.*;

// public class TypeSound {
//     public static void main(String[] args) {
//         try {
//             // Open a line to the audio output
//             AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
//             DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
//             SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
//             line.open(format);

//             // Generate a sine wave
//             byte[] buffer = new byte[1024];
//             for (int i = 0; i < buffer.length; i += 2) {
//                 double angle = i / (double) buffer.length * Math.PI * 2;
//                 short sample = (short) (Math.sin(angle) * Short.MAX_VALUE);
//                 buffer[i] = (byte) (sample & 0xff);
//                 buffer[i + 1] = (byte) ((sample >> 8) & 0xff);
//             }

//             // Play the sine wave
//             line.start();
//             line.write(buffer, 0, buffer.length);
//             line.drain();
//             line.stop();
//             line.close();
//         } catch (Exception ex) {
//             ex.printStackTrace();
//         }
//     }
// }
